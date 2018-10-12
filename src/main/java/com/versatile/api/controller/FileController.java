package com.versatile.api.controller;

import com.sun.org.apache.xpath.internal.operations.Mult;
import com.versatile.api.entity.File;
import com.versatile.api.exception.*;
import com.versatile.api.mapper.FileMapper;
import com.versatile.api.mapper.JobMapper;
import com.versatile.api.ressource.*;
import com.versatile.api.service.*;
import org.apache.catalina.core.ApplicationPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {

    @Autowired
    JobService jobService;

    @Autowired
    FileService fileService;

    @Autowired
    JobMapper jobMapper;

    @GetMapping("/jobs/files")
    public List<FileRessource> getJobFiles() {
        return fileService.getFiles();
    }

    @GetMapping("/jobs/{id}/files")
    public List<FileRessource> getFilesByJob(@PathVariable int id) throws JobNotFoundException {
        JobRessource job = jobService.getById(id);
        return fileService.getByJob(job);
    }

    @GetMapping("/jobs/files/{id}")
    FileRessource getById(@PathVariable int id) throws FileJobNotFoundException {
        return fileService.getById(id);
    }

    @PostMapping("/jobs/{id}/files")
    public List<FileRessource> uploadMultipleFiles(@PathVariable int id, HttpServletRequest request)
            throws JobNotFoundException, IOException, ServletException {
        List<File> filesToSave = new ArrayList<>();
        JobRessource job = jobService.getById(id);
        Part file = request.getPart("file");
        String message = "";

        byte[] bytes = new byte[0];
        file.getInputStream().read(bytes);

        filesToSave.add(new File(0, file.getContentType(), file.getSubmittedFileName(), bytes, jobMapper.modelToEntity(job)));
        return fileService.save(filesToSave);
    }

    @PutMapping("/jobs/files/{id}")
    FileRessource updateFile(@RequestBody FileRessource file, @PathVariable int id) {
        return fileService.updateFile(file, id);
    }

    @DeleteMapping("/jobs/files/{id}")
    void deleteFile(@PathVariable int id) {
        fileService.deleteById(id);
    }
}
