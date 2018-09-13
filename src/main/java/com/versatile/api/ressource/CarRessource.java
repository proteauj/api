package com.versatile.api.ressource;

public class CarRessource {
    private Integer id;
    private ModelRessource model;
    private Integer year;
    private String vin;

    public CarRessource() {
    }

    public CarRessource(Integer id, ModelRessource model, Integer year, String vin) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.vin = vin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ModelRessource getModel() {
        return model;
    }

    public void setModel(ModelRessource model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}