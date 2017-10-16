package com.herokuapp.data;

import com.google.gson.Gson;

public class DataEntityDescription implements DataEntityValidatable {
    private Integer checkbox1selections;
    private Integer checkbox2Selections;

    public static DataEntityDescription getInstance() {
        return new DataEntityDescription();
    }

    @Override
    public Integer getCheckbox1Selections() {
        return checkbox1selections;
    }

    @Override
    public Integer getCheckbox2Selections() {
        return checkbox2Selections;
    }

    public DataEntityDescription withCheckbox1Selections(Integer numberOfSelections) {
        checkbox1selections = numberOfSelections;
        return this;
    }

    public DataEntityDescription withCheckbox2Selections(Integer numberOfSelections) {
        checkbox2Selections = numberOfSelections;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
