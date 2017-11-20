package com.trello.data.user;

public class TrelloUserProvider {
    public static TrelloUserProvider getInstance() {
        return new TrelloUserProvider();
    }

    public TrelloUser get() {
        return TrelloUser.getInstance();
    }
}
