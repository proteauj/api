package com.versatile.api.service;

import com.versatile.api.entity.File;
import com.versatile.api.entity.JobTask;
import com.versatile.api.exception.FileJobNotFoundException;
import com.versatile.api.exception.JobTaskNotFoundException;
import com.versatile.api.mapper.*;
import com.versatile.api.repository.FileRepository;
import com.versatile.api.ressource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    @Autowired
    FileRepository repository;

    @Autowired
    FileMapper mapper;

    @Autowired
    JobMapper jobMapper;

    public List<FileRessource> getFiles() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public byte[] getById(int id) throws FileJobNotFoundException {
        File file = repository.findById(id)
                .orElseThrow(() -> new FileJobNotFoundException(id));
        return file.getFile();
//        return mapper.entityToModel(repository.findById(id)
//                .orElseThrow(() -> new FileJobNotFoundException(id)));
    }

    public List<FileRessource> getByJob(JobRessource job) {
        return mapper.entitiesToModels(repository.findByJob(jobMapper.modelToEntity(job)));
    }

    public List<FileRessource> save(List<File> files) {
        List<FileRessource> filesRessSaved = new ArrayList<FileRessource>();

        for (File file: files) {
            FileRessource fileSaved = mapper.entityToModel(repository.save(file));
            filesRessSaved.add(fileSaved);
        }

        return filesRessSaved;
    }

    public FileRessource updateFile(FileRessource file, int id) {
        File newFile = mapper.modelToEntity(file);

        return repository.findById(id)
                .map(oldFile -> {
                    oldFile.setFile(newFile.getFile());
                    oldFile.setName(newFile.getName());
                    oldFile.setJob(newFile.getJob());
                    return mapper.entityToModel(repository.save(oldFile));
                })
                .orElseGet(() -> {
                    newFile.setIdFile(id);
                    return mapper.entityToModel(repository.save(newFile));
                });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public byte[] getBytesFromPart(Part part) throws IOException {
        InputStream partInputStream=part.getInputStream();
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        byte[] chunk=new byte[4096];
        int amountRead;

        while ((amountRead=partInputStream.read(chunk)) != -1) {
            outputStream.write(chunk,0,amountRead);
        }

        if (outputStream.size() == 0) {
            return null;
        } else {
            return outputStream.toByteArray();
        }
    }
}
