package com.herokuapp.data;

public class DataEntityProvider {
    public static DataEntityProvider getInstance() {
        return new DataEntityProvider();
    }

    public DataEntity get(DataEntityDescription description) {
        return DataEntity.getInstance(description.getCheckbox1Selections(),description.getCheckbox2Selections());
    }
}
