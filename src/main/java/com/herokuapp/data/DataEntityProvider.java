package com.herokuapp.data;

public class DataEntityProvider {
    public static DataEntityProvider getInstance() {
        return new DataEntityProvider();
    }

    public DataEntity get(DataEntityDescription description) {
        /*  This would eventually be replaced by use of Repositories (representations of data sources).
            The Repository implementations would include connections/queries of databases,
            use of web services, or use of an application UI.
            That leaves this class to be responsible for composing the requested data,
            possibly from multiple repositories.
            The repositories are responsible for how the data is acquired.
         */
        return DataEntity.getInstance(description.getCheckbox1Selections(),description.getCheckbox2Selections());
    }
}
