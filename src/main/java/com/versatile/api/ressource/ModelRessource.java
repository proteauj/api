package com.versatile.api.ressource;

public class ModelRessource {
    private Integer id;
    private MakeRessource make;
    private String code;
    private String title;

    public ModelRessource() {
    }

    public ModelRessource(Integer id, MakeRessource make, String code, String title) {
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

    public MakeRessource getMake() {
        return make;
    }

    public void setMake(MakeRessource make) {
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