package com.versatile.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idJob;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_car")
    private Car car;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_status")
    private Status status;

    private String description;
    private Date arrivalDate;
    private Date toDeliverDate;

    public Job() {
    }

    public Job(Integer idJob, Car car, Status status, String description, Date arrivalDate, Date toDeliverDate) {
        this.idJob = idJob;
        this.car = car;
        this.status = status;
        this.description = description;
        this.arrivalDate = arrivalDate;
        this.toDeliverDate = toDeliverDate;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
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

    @Override
    public String toString() {
        return "Job{" +
                "idJob=" + idJob +
                ", car=" + car +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", toDeliverDate=" + toDeliverDate +
                '}';
    }
}
