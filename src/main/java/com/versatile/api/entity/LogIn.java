package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class LogIn {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String password;

    @Column(name = "nb_failed_login")
    private Integer nbFailedLogin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user")
    private Employee user;

    public LogIn() {}

    public LogIn(Integer id, String password, Integer nbFailedLogin, Employee user) {
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

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LogIn{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", nbFailedLogin=" + nbFailedLogin +
                ", user=" + user +
                '}';
    }
}
