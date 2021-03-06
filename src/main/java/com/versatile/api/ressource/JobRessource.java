package com.versatile.api.ressource;

import java.util.Date;

public class JobRessource {
    private Integer idJob;
    private CarRessource car;
    private StatusRessource status;
    private String description;
    private Date arrivalDate;
    private Date toDeliverDate;
    private String numJobClient;
    private ClientRessource client;

    public JobRessource() {
    }

    public JobRessource(Integer idJob, CarRessource car, StatusRessource status, String description, Date arrivalDate, Date toDeliverDate, String numJobClient, ClientRessource client) {
        this.idJob = idJob;
        this.car = car;
        this.status = status;
        this.description = description;
        this.arrivalDate = arrivalDate;
        this.toDeliverDate = toDeliverDate;
        this.numJobClient = numJobClient;
        this.client = client;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
    }

    public CarRessource getCar() {
        return car;
    }

    public void setCar(CarRessource car) {
        this.car = car;
    }

    public StatusRessource getStatus() {
        return status;
    }

    public void setStatus(StatusRessource status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getToDeliverDate() {
        return toDeliverDate;
    }

    public void setToDeliverDate(Date toDeliverDate) {
        this.toDeliverDate = toDeliverDate;
    }

    public String getNumJobClient() {
        return numJobClient;
    }

    public void setNumJobClient(String numJobClient) {
        this.numJobClient = numJobClient;
    }

    public ClientRessource getClient() {
        return client;
    }

    public void setClient(ClientRessource client) {
        this.client = client;
    }
}