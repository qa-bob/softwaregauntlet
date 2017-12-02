package com.softwareonpurpose.gauntlet.environment;

class BetaAcceptanceEnvironment extends EnvironmentDefinition {
    static final String NAME = "beta";

    private BetaAcceptanceEnvironment() {
        super("https://trello.com");
    }

    public static BetaAcceptanceEnvironment getInstance() {
        return new BetaAcceptanceEnvironment();
    }
}
