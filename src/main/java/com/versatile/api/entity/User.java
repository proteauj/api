package com.versatile.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String email;
    private String name;
    private int idRole;
    private int idUserType;

    public User() {}

    public User(int id, String email, String name, int idRole, int idUserType) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.idRole = idRole;
        this.idUserType = idUserType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", idRole=" + idRole +
                ", idUserType=" + idUserType +
                '}';
    }
}
