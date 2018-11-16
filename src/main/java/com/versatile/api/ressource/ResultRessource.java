package com.versatile.api.ressource;

public class ResultRessource {
    private String value;
    private String valueId;
    private String variable;
    private Integer variableId;

    public ResultRessource() {
    }

    public ResultRessource(String value, String valueId, String variable, Integer variableId) {
        this.value = value;
        this.valueId = valueId;
        this.variable = variable;
        this.variableId = variableId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public Integer getVariableId() {
        return variableId;
    }

    public void setVariableId(Integer variableId) {
        this.variableId = variableId;
    }
}