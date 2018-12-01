package com.versatile.api.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class File {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idFile;

    //@Lob
    private byte[] file;

    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_job")
    private Job job;

    private String type;

    public File() {
    }

    public File(Integer idFile, String type, String name, byte[] file, Job job) {
        this.idFile = idFile;
        this.type = type;
        this.name = name;
        this.file = file;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "File{" +
                "idFile=" + idFile +
                ", file=" + Arrays.toString(file) +
                ", name='" + name + '\'' +
                ", job=" + job +
                '}';
    }
}
