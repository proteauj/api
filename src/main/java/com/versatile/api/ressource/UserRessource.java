package com.versatile.api.ressource;

public class UserRessource {
    Integer idUser;
    String email;
    String name;
    UserRoleRessource role;
    UserTypeRessource type;
    byte[] image;

    public UserRessource() {
    }

    public UserRessource(Integer idUser, String email, String name, UserRoleRessource role, UserTypeRessource type, byte[] image) {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}