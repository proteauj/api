package com.versatile.api.ressource;

public class UserTypeRessource {
    int id;
    String description;

    public UserTypeRessource() {
    }

    public UserTypeRessource(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}