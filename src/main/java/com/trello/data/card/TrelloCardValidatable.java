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
        if (comparator == null) {
            return true;
        } else if (comparator.getId() != null) {
            return comparator.getId().equals(getId());
        }
        boolean equivalent = equivalent(comparator.getList(), getList());
        equivalent &= equivalent(comparator.getTitle(), getTitle());
        equivalent &= equivalent(comparator.getPosition(), getPosition());
        equivalent &= equivalent(comparator.getBoard(), getBoard());
        equivalent &= equivalent(comparator.getNumber(), getNumber());
        return equivalent;
    }

    private boolean equivalent(Object comparatorValue, Object thisValue) {
        return comparatorValue == null || comparatorValue.equals(thisValue);
    }

    public TrelloCardDefinition toDefinition() {
        return TrelloCardDefinition.getInstance().withTitle(getTitle()).withInList(getList()).withId(getId())
                .withPosition(getPosition()).withBoard(getBoard()).withNumber(getNumber());
    }
}
