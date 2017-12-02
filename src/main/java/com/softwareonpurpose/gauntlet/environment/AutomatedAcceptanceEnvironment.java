package com.softwareonpurpose.gauntlet.environment;

public class AutomatedAcceptanceEnvironment extends EnvironmentDefinition {
    @SuppressWarnings("SpellCheckingInspection")
    static final String NAME = "qaauto";

    private AutomatedAcceptanceEnvironment() {
        super("https://trello.com");
    }

    public static AutomatedAcceptanceEnvironment getInstance() {
        return new AutomatedAcceptanceEnvironment();
    }
}
