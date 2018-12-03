package com.versatile.api.mapper;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.versatile.api.exception.MakeNotFoundException;
import com.versatile.api.exception.ModelNotFoundException;
import com.versatile.api.ressource.*;
import com.versatile.api.service.CarService;
import com.versatile.api.service.MakeService;
import com.versatile.api.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleMapper {

    @Autowired
    MakeService makeService;

    @Autowired
    ModelService modelService;

    public CarRessource getCarFromVehicle(VehicleRessource vehicle) {
        String vin = vehicle.getSearchCriteria().split(":")[1];

        Map<String, ResultRessource> mapResults =
                vehicle.getResults().stream().collect(Collectors.toMap(x -> x.getVariableId().toString(), x -> x));

        ResultRessource makeResult = mapResults.get("26");
        MakeRessource make;
        try {
            make = makeService.getByCode(makeResult.getValueId());
        } catch (MakeNotFoundException e) {
            make = new MakeRessource(null, makeResult.getValueId(), makeResult.getValue());
        }

        ResultRessource modelResult = mapResults.get("28");
        ModelRessource model;

        try {
            model = modelService.getByCode(modelResult.getValueId());
        } catch (ModelNotFoundException e) {
            model = new ModelRessource(null, make, modelResult.getValueId(), modelResult.getValue());
        }

        ResultRessource yearResult = mapResults.get("29");
        Integer year = Integer.parseInt(yearResult.getValue());
        return new CarRessource(null, model, year, vin, "");
    }
}
