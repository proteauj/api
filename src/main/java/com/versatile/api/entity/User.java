package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String email;
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_role")
    private UserRole role;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_user_type")
    private UserType userType;

    public User() {}

    public User(Integer id, String email, String name, UserRole role, UserType userType) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.role = role;
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role.toString() +
                ", userType=" + userType.toString() +
                '}';
    }
}
