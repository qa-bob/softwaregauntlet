package com.trello.data.user;

public class TrelloUserRepository {
    public static TrelloUserRepository getInstance() {
        return new TrelloUserRepository();
    }

    public TrelloUser query() {
        return TrelloUser.getInstance();
    }
}
