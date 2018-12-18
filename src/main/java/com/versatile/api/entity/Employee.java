package com.versatile.api.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idUser;
    private String email;
    private String name;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_type")
    private UserType type;

    private byte[] image;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "employee_role",
            joinColumns = { @JoinColumn(name = "fk_user") },
            inverseJoinColumns = { @JoinColumn(name = "fk_role") }
    )
    private List<UserRole> roles;

    public Employee() {}

    public Employee(Integer idUser, String email, String name, UserType type, byte[] image, List<UserRole> roles) {
        this.idUser = idUser;
        this.email = email;
        this.name = name;
        this.type = type;
        this.image = image;
        this.roles = roles;
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

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idUser=" + idUser +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", image=" + Arrays.toString(image) +
                ", roles=" + roles +
                '}';
    }
}
