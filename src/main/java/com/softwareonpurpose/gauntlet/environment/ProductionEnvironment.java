package com.softwareonpurpose.gauntlet.environment;

public class ProductionEnvironment extends EnvironmentDefinition {

    private ProductionEnvironment() {
        domainUri = "http://the-internet.herokuapp.com";
    }

    public static ProductionEnvironment getInstance() {
        return new ProductionEnvironment();
    }
}
