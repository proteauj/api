package com.versatile.api.ressource;

public class JobRessource {
    private Integer id;
    private CarRessource car;
    private StatusRessource status;
    private String description;

    public JobRessource() {
    }

    public JobRessource(Integer id, CarRessource car, StatusRessource status, String description) {
        this.id = id;
        this.car = car;
        this.status = status;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}