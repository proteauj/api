package com.versatile.api.ressource;

public class UserRoleRessource {
    int idRole;
    String description;

    public UserRoleRessource() {
    }

    public UserRoleRessource(int idRole, String description) {
        this.idRole = idRole;
        this.description = description;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}