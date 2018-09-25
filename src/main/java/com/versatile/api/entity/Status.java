package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idStatus;

    private String status;

    public Status() {
    }

    public Status(Integer idStatus, String status) {
        this.idStatus = idStatus;
        this.status = status;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "idStatus=" + idStatus +
                ", status='" + status + '\'' +
                '}';
    }
}
