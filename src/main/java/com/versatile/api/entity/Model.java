package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_make")
    private Make make;

    private String code;
    private String title;

    public Model() {}

    public Model(Integer id, Make make, String code, String title) {
        this.id = id;
        this.make = make;
        this.code = code;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", make=" + make.toString() +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
