package com.softwareonpurpose.gauntlet.environment;

public class Environment {

    private static EnvironmentDefinition environment;

    private Environment() {
    }

    public static EnvironmentDefinition getInstance() {
        if (environment == null) {
            String environmentProperty = System.getProperty("env");
            String environment = environmentProperty == null ? "" : environmentProperty;
            switch (environment) {
                default:
                    Environment.environment = ProductionEnvironment.getInstance();
            }
        }
        return environment;
    }
}
