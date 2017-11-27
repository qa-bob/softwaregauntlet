package com.trello.data.card;

import com.google.gson.Gson;

public abstract class TrelloCardValidatable {
    public abstract String getList();

    public abstract String getTitle();

    public abstract String getId();

    public abstract String getPosition();

    public abstract String getBoard();

    public abstract String getNumber();

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    boolean equivalent(TrelloCard comparator) {
        if (comparator == null || getId().equals(comparator.getId())) {
            return true;
        }
        boolean equivalent = comparator.getList() == null || getList().equals(comparator.getList());
        equivalent &= comparator.getTitle() == null || getTitle().equals(comparator.getTitle());
        equivalent &= comparator.getPosition() == null || getPosition().equals(comparator.getPosition());
        equivalent &= comparator.getBoard() == null || getBoard().equals(comparator.getBoard());
        equivalent &= comparator.getNumber() == null || getNumber().equals(comparator.getNumber());
        return equivalent;
    }
}
