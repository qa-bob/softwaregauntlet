package com.softwareonpurpose.gauntlet.environment;

class CapacityEnvironment extends EnvironmentDefinition {
    static final String NAME = "capacity";

    CapacityEnvironment() {
        super("https://trello.com");
    }

    public static EnvironmentDefinition getInstance() {
        return new CapacityEnvironment();
    }
}
