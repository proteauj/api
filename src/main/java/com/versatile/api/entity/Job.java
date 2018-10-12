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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_status")
    private Status status;

    private String description;
    private Date dateStart;
    private Date dateFinish;

    public Job() {
    }

    public Job(Integer idJob, Car car, Status status, String description, Date dateStart, Date dateFinish) {
        this.idJob = idJob;
        this.car = car;
        this.status = status;
        this.description = description;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    @Override
    public String toString() {
        return "Job{" +
                "idJob=" + idJob +
                ", car=" + car +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                '}';
    }
}
