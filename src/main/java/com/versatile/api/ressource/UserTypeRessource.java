package com.versatile.api.ressource;

public class UserTypeRessource {
    int idType;
    String description;

    public UserTypeRessource() {
    }

    public UserTypeRessource(int idType, String description) {
        this.idType = idType;
        this.description = description;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}