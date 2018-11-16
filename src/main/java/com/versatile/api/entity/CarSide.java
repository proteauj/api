package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class CarSide {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCarSide;
    private String name;

    public CarSide() {}

    public CarSide(Integer idCarSide, String name) {
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

    @Override
    public String toString() {
        return "CarSideRessource{" +
                "idCarSide=" + idCarSide +
                ", name='" + name + '\'' +
                '}';
    }
}
