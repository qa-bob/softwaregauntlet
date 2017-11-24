package com.trello.data.user;

import com.google.gson.Gson;

public abstract class TrelloUserValidatable {
    abstract String getPassword();

    abstract String getUsername();

    abstract String getInitials();

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
