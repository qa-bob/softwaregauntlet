package com.softwareonpurpose.gauntlet.environment;

class DevIntegrationEnvironment extends EnvironmentDefinition {
    static final String NAME = "dev";

    private DevIntegrationEnvironment() {
        super("https://trello.com");
    }

    public static DevIntegrationEnvironment getInstance() {
        return new DevIntegrationEnvironment();
    }
}
