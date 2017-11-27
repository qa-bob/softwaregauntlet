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

    public boolean equivalent(TrelloCardValidatable comparator) {
        if (comparator == null || getId().equals(comparator.getId())) {
            return true;
        }
        boolean equivalent = comparator.getList() == null || comparator.getList().equals(getList());
        equivalent &= comparator.getTitle() == null || comparator.getTitle().equals(getTitle());
        equivalent &= comparator.getPosition() == null || comparator.getPosition().equals(getPosition());
        equivalent &= comparator.getBoard() == null || comparator.getBoard().equals(getBoard());
        equivalent &= comparator.getNumber() == null || comparator.getNumber().equals(getNumber());
        return equivalent;
    }
}
