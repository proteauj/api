package com.versatile.api.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idUser;
    private String email;
    private String name;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_role")
    private UserRole role;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_type")
    private UserType type;

    private byte[] image;

    public Employee() {}

    public Employee(Integer idUser, String email, String name, UserRole role, UserType type, byte[] image) {
        this.idUser = idUser;
        this.email = email;
        this.name = name;
        this.role = role;
        this.type = type;
        this.image = image;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idUser=" + idUser +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", type=" + type +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
