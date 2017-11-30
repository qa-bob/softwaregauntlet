package com.trello.data.user;

public class TrelloUserDefinition extends TrelloUserValidatable {

    @Override
    String getUsername() {
        return null;
    }

    @Override
    String getInitials() {
        return null;
    }

    public static TrelloUserDefinition getInstance() {
        return new TrelloUserDefinition();
    }
}
