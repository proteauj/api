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

import java.io.FileNotFoundException;
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

    public FileRessource getById(int id) throws FileJobNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new FileJobNotFoundException(id)));
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
}
