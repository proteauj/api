package com.versatile.api.ressource;

public class ClientRessource {
    private Integer idClient;
    private String name;
    private String address;
    private String telephone;
    private String email;

    public ClientRessource() {
    }

    public ClientRessource(Integer idClient, String name, String address, String telephone, String email) {
        this.idClient = idClient;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}