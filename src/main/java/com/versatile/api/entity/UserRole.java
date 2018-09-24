package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String description;

    public UserRole() {}

    public UserRole(Integer id, String description) {
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
        return "UserRole{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
