package com.versatile.api.ressource;

public class FileRessource {
    private Integer idFile;
    private byte[] file;
    private String name;
    private String type;
    private JobRessource job;

    public FileRessource() {
    }

    public FileRessource(Integer idFile, byte[] file, String name, String type, JobRessource job) {
        this.idFile = idFile;
        this.file = file;
        this.name = name;
        this.type = type;
        this.job = job;
    }

    public Integer getIdFile() {
        return idFile;
    }

    public void setIdFile(Integer idFile) {
        this.idFile = idFile;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JobRessource getJob() {
        return job;
    }

    public void setJob(JobRessource job) {
        this.job = job;
    }
}