package com.trello.data.card;

import com.google.gson.Gson;

public abstract class TrelloCardValidatable {
    public abstract String getList();

    abstract String getTitle();

    abstract String getId();

    public abstract String getPosition();

    public abstract String getBoard();

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
