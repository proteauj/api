package com.versatile.api.ressource;

public class LogInRessource {
    private Integer id;
    private String password;
    private Integer nbFailedLogin;
    private UserRessource user;

    public LogInRessource() {
    }

    public LogInRessource(Integer id, String password, Integer nbFailedLogin, UserRessource user) {
        this.id = id;
        this.password = password;
        this.nbFailedLogin = nbFailedLogin;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNbFailedLogin() {
        return nbFailedLogin;
    }

    public void setNbFailedLogin(Integer nbFailedLogin) {
        this.nbFailedLogin = nbFailedLogin;
    }

    public UserRessource getUser() {
        return user;
    }

    public void setUser(UserRessource user) {
        this.user = user;
    }
}