package com.trello.data.user;

public class TrelloUserDefinition extends TrelloUserValidatable {
    private static final String username = null;
    private static final String initials = null;

    public static TrelloUserDefinition getInstance() {
        return new TrelloUserDefinition();
    }

    @Override
    String getUsername() {
        return username;
    }

    @Override
    String getInitials() {
        return initials;
    }
}
