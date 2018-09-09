package com.versatile.api.model;

public class UserModel {
    int id;
    String email;
    String name;
    int idRole;
    int idUserType;

    public UserModel() {
    }

    public UserModel(int id, String email, String name, int idRole, int idUserType) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.idRole = idRole;
        this.idUserType = idUserType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(int idUserType) {
        this.idUserType = idUserType;
    }
}