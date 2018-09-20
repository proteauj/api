package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String email;
    private String name;

    /*
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_role")
    private Role role;
     */
    @Column(name = "fk_role")
    private int idRole;

    /*
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_userType")
    private UserType userType;
     */
    @Column(name = "fk_userType")
    private int idUserType;

    public User() {}

    public User(Integer id, String email, String name, int idRole, int idUserType) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.idRole = idRole;
        this.idUserType = idUserType;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", idRole=" + idRole +
                ", idUserType=" + idUserType +
                '}';
    }
}
