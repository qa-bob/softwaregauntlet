package com.softwareonpurpose.gauntlet.environment;

class CapacityEnvironment extends EnvironmentDefinition {
    static final String NAME = "capacity";

    private CapacityEnvironment() {
        super("https://trello.com");
    }

    public static CapacityEnvironment getInstance() {
        return new CapacityEnvironment();
    }
}
