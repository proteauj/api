package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_model")
    private Model model;

    private Integer year;
    private String vin;

    public Car() {}

    public Car(Integer id, Model model, Integer year, String vin) {
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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model=" + model +
                ", year=" + year +
                ", vin='" + vin + '\'' +
                '}';
    }
}
