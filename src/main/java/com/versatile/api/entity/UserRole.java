package com.versatile.api.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idRole;
    private String description;

    @ManyToMany(mappedBy = "roles")
    private List<Employee> employees;

    public UserRole() {
    }

    public UserRole(Integer idRole, String description) {
        this.idRole = idRole;
        this.description = description;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
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
                "idRole=" + idRole +
                ", description='" + description + '\'' +
                '}';
    }
}
