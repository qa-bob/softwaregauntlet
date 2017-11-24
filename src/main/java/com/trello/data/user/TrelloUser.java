package com.trello.data.user;

public class TrelloUser extends TrelloUserValidatable {
    private final String username = "cstockto@teksystems.com";
    private final String password = "T3kSystem$";
    private final String initials = "T";

    public static TrelloUser getInstance() {
        return new TrelloUser();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getInitials() {
        return initials;
    }
}
