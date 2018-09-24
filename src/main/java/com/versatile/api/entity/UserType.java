package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class UserType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idType;
    private String description;

    public UserType() {
    }

    public UserType(Integer idType, String description) {
        this.idType = idType;
        this.description = description;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "idType=" + idType +
                ", description='" + description + '\'' +
                '}';
    }
}
