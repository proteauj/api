package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_car")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "fk_status")
    private Status status;

    private String description;

    public Job() {
    }

    public Job(Integer id, Car car, Status status, String description) {
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", car=" + car.toString() +
                ", status=" + status.toString() +
                ", description='" + description + '\'' +
                '}';
    }
}
