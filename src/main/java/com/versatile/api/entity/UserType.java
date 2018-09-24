package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class UserType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String description;

    public UserType() {}

    public UserType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
