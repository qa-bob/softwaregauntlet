package com.trello.data.user;

public class TrelloUser implements TrelloUserValidatable{
    public static TrelloUser getInstance() {
        return new TrelloUser();
    }

    @Override
    public String getPassword() {
        return "T3kSystem$";
    }

    @Override
    public String getUsername() {
        return "cstockto@teksystems.com";
    }
}
