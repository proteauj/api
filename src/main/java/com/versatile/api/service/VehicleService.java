package com.versatile.api.service;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.versatile.api.exception.CarNotFoundException;
import com.versatile.api.mapper.CarMapper;
import com.versatile.api.mapper.VehicleMapper;
import com.versatile.api.repository.CarRepository;
import com.versatile.api.ressource.CarRessource;
import com.versatile.api.ressource.VehicleRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;

@Service
public class VehicleService {
    @Autowired
    CarRepository repository;

    @Autowired
    CarMapper mapper;

    @Autowired
    VehicleMapper vehicleMapper;

    @Autowired
    RestTemplate restTemplate;

    public CarRessource getByVin(String vin) throws IOException, SAXException, ParserConfigurationException {
        CarRessource car;

        try {
            car = mapper.entityToModel(repository.getByVin(vin)
                    .orElseThrow(() -> new CarNotFoundException(vin)));
        } catch (CarNotFoundException e) {
            UriComponents builder = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host("vpic.nhtsa.dot.gov")
                    .path("api/vehicles/DecodeVin/{vin}")
                    .query("format={format}").buildAndExpand(vin, "json");
            URI uri = builder.toUri();
            ResponseEntity<String> respEntity = restTemplate.getForEntity(uri, String.class);

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

            VehicleRessource vehicle = mapper.readValue(respEntity.getBody(), VehicleRessource.class);
            car = vehicleMapper.getCarFromVehicle(vehicle);

            String searchImage = car.getModel().getMake().getTitle() + " " +
                                 car.getModel().getTitle() + " " +
                                 car.getYear();
            car.setImageUrl(getCarImage(searchImage));
        }

        return car;
    }

    public String getCarImage(String search) throws ParserConfigurationException, IOException, SAXException {
        UriComponents builder = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("www.carimagery.com")
                .path("api.asmx/GetImageUrl")
                .query("searchTerm={search}").buildAndExpand(search);

        URI uri = builder.toUri();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(responseEntity.getBody()));

        Document doc = db.parse(is);
        NodeList nodes = doc.getChildNodes();
        String node1 = nodes.item(0).getLastChild().getNodeValue();

        return node1;
    }
}
