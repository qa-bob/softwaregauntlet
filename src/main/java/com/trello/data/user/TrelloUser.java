package com.trello.data.user;

public class TrelloUser extends TrelloUserValidatable {

    public static TrelloUser getInstance() {
        return new TrelloUser();
    }

    public String getPassword() {
        return "T3kSystem$";
    }

    @Override
    public String getUsername() {
        return "cstockto@teksystems.com";
    }

    @Override
    public String getInitials() {
        return "T";
    }
}
