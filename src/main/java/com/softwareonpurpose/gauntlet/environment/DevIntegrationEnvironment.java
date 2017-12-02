package com.softwareonpurpose.gauntlet.environment;

class DevIntegrationEnvironment extends EnvironmentDefinition {
    static final String NAME = "dev";

    private DevIntegrationEnvironment() {
        super("https://trello.com");
    }

    public static EnvironmentDefinition getInstance() {
        return new DevIntegrationEnvironment();
    }
}
