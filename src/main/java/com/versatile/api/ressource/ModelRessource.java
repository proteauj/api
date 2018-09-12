package com.versatile.api.ressource;

import com.versatile.api.entity.Make;

public class ModelRessource {
    private Integer id;
    private Make make;
    private String code;
    private String title;

    public ModelRessource() {
    }

    public ModelRessource(Integer id, Make make, String code, String title) {
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
}