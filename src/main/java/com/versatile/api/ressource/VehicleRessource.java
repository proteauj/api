package com.versatile.api.ressource;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleRessource {
    @JsonIgnore
    private int Count;
    @JsonIgnore
    private String Message;
    @JsonIgnore
    private String SearchCriteria;
    private ArrayList<ResultRessource> Results;

    public VehicleRessource() {
    }

    public VehicleRessource(Integer count, String message, String searchCriteria, ArrayList<ResultRessource> results) {
        this.Count = count;
        this.Message = message;
        this.SearchCriteria = searchCriteria;
        this.Results = results;
    }

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        this.Count = count;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }

    public String getSearchCriteria() {
        return SearchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.SearchCriteria = searchCriteria;
    }

    public ArrayList<ResultRessource> getResults() {
        return Results;
    }

    public void setResults(ArrayList<ResultRessource> results) {
        this.Results = results;
    }
}
