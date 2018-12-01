package com.versatile.api.entity;

import javax.persistence.*;

@Entity
/*
@SecondaryTables(value = {
        @SecondaryTable(name = "user_type", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "fk_type", foreignKey = @ForeignKey(name = "id_type"))),
        @SecondaryTable(name = "user_role", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "fk_role", foreignKey = @ForeignKey(name = "id_role")))
})*/
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idUser;
    private String email;
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_role")
    private UserRole role;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_type")
    private UserType type;

    public Employee() {}

    public Employee(Integer idUser, String email, String name, UserRole role, UserType type) {
        this.idUser = idUser;
        this.email = email;
        this.name = name;
        this.role = role;
        this.type = type;
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

    @Override
    public String toString() {
        return "Employee{" +
                "idUser=" + idUser +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role.toString() +
                ", type=" + type.toString() +
                '}';
    }
}
