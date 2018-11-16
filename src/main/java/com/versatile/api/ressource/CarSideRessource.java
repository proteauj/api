package com.versatile.api.ressource;

public class CarSideRessource {
    private Integer idCarSide;
    private String name;

    public CarSideRessource() {}

    public CarSideRessource(Integer idCarSide, String name) {
        this.idCarSide = idCarSide;
        this.name = name;
    }

    public Integer getIdCarSide() {
        return idCarSide;
    }

    public void setIdCarSide(Integer idCarSide) {
        this.idCarSide = idCarSide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
