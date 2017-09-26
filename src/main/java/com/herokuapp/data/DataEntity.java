package com.herokuapp.data;

public class DataEntity implements DataEntityValidatable {
    private final int checkbox1selections;
    private final int checkbox2selections;

    private DataEntity(int checkbox1selections, int checkbox2selections) {
        this.checkbox1selections = checkbox1selections;
        this.checkbox2selections = checkbox2selections;
    }

    public static DataEntity getInstance(int checkbox1selections, int checkbox2selections) {
        return new DataEntity(checkbox1selections, checkbox2selections);
    }

    @Override
    public Integer getCheckbox1Selections() {
        return checkbox1selections;
    }

    @Override
    public Integer getCheckbox2Selections() {
        return checkbox2selections;
    }
}
