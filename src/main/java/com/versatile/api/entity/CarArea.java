package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class CarArea {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCarArea;

    private String code;

    @ManyToOne
    @JoinColumn(name = "fk_car_side")
    private CarSide carSide;

    public CarArea() {}

    public CarArea(Integer idCarArea, String code, CarSide carSide) {
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

    public CarSide getCarSide() {
        return carSide;
    }

    public void setCarSide(CarSide carSide) {
        this.carSide = carSide;
    }

    @Override
    public String toString() {
        return "CarAreaRessource{" +
                "idCarArea=" + idCarArea +
                ", code='" + code + '\'' +
                ", carSide=" + carSide +
                '}';
    }
}
