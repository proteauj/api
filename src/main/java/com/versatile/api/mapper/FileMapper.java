package com.versatile.api.mapper;

import com.versatile.api.entity.File;
import com.versatile.api.ressource.FileRessource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Mapper(componentModel = "spring", uses = {JobMapper.class})
public interface FileMapper {
//    @Mappings({
//            @Mapping(source = "originFile", target = "file")
//    })
    FileRessource entityToModel(File originFile);

//    default MultipartFile byteArrayToFile(File file) throws IOException {
//        FileItem fileItem = new DiskFileItem("fileData", file.getType(),true, file.getName(),
//                100000000, new java.io.File(System.getProperty("java.io.tmpdir")));
//        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
//        return multipartFile;
//    }

    @Mappings({
            @Mapping(source = "file", target = "file")
    })
    File modelToEntity(FileRessource model);

    default byte[] fileToByteArray(MultipartFile file) throws IOException {
        if (file != null) {
            return file.getBytes();
        }
        return null;
    }

    List<FileRessource> entitiesToModels(List<File> allFile);
}
