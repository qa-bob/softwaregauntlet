package com.softwareonpurpose.gauntlet.environment;

public class AutomatedAcceptanceEnvironment extends EnvironmentDefinition {
    static final String NAME = "auto";

    private AutomatedAcceptanceEnvironment() {
        super("https://trello.com");
    }

    public static EnvironmentDefinition getInstance() {
        return new AutomatedAcceptanceEnvironment();
    }
}
