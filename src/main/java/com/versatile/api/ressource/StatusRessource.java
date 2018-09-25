package com.versatile.api.ressource;

public class StatusRessource {
    private Integer idStatus;
    private String status;

    public StatusRessource() {
    }

    public StatusRessource(Integer idStatus, String status) {
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
}