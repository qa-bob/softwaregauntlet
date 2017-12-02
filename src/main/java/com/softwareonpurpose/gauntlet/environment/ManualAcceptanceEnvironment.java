package com.softwareonpurpose.gauntlet.environment;

class ManualAcceptanceEnvironment extends EnvironmentDefinition {
    @SuppressWarnings("SpellCheckingInspection")
    static final String NAME = "qamanual";

    private ManualAcceptanceEnvironment() {
        super("https://trello.com");
    }

    public static ManualAcceptanceEnvironment getInstance() {
        return new ManualAcceptanceEnvironment();
    }
}
