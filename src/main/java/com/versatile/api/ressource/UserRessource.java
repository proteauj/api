package com.versatile.api.ressource;

public class UserRessource {
    int id;
    String email;
    String name;
    UserRoleRessource role;
    UserTypeRessource type;

    public UserRessource() {
    }

    public UserRessource(int id, String email, String name, UserRoleRessource role, UserTypeRessource type) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.role = role;
        this.type = type;
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

    public UserRoleRessource getRole() {
        return role;
    }

    public void setRole(UserRoleRessource role) {
        this.role = role;
    }

    public UserTypeRessource getType() {
        return type;
    }

    public void setType(UserTypeRessource type) {
        this.type = type;
    }
}