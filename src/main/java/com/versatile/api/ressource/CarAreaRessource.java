package com.versatile.api.ressource;

public class CarAreaRessource {

    private Integer idCarArea;
    private String code;
    private CarSideRessource carSide;

    public CarAreaRessource() {}

    public CarAreaRessource(Integer idCarArea, String code, CarSideRessource carSide) {
        this.idCarArea = idCarArea;
        this.code = code;
        this.carSide = carSide;
    }

    public Integer getIdCarArea() {
        return idCarArea;
    }

    public void setIdCarArea(Integer idCarArea) {
        this.idCarArea = idCarArea;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CarSideRessource getCarSide() {
        return carSide;
    }

    public void setCarSide(CarSideRessource carSide) {
        this.carSide = carSide;
    }
}
