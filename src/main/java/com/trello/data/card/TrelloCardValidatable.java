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
        String details = new Gson().toJson(this);
        return String.format("Trello Card: %s", details.replace("{}", "{any}"));
    }

    public boolean equivalent(TrelloCardValidatable comparator) {
        if (comparator == null) {
            return true;
        } else if (comparator.getId() != null) {
            return comparator.getId().equals(getId());
        }
        boolean equivalent = isEquivalent(comparator.getList(), getList());
        equivalent &= isEquivalent(comparator.getTitle(), getTitle());
        equivalent &= isEquivalent(comparator.getPosition(), getPosition());
        equivalent &= isEquivalent(comparator.getBoard(), getBoard());
        equivalent &= isEquivalent(comparator.getNumber(), getNumber());
        return equivalent;
    }

    private boolean isEquivalent(String comparatorValue, String thisValue) {
        return comparatorValue == null || comparatorValue.equals(thisValue);
    }

    public TrelloCardDefinition toDefinition() {
        return TrelloCardDefinition.getInstance().withTitle(getTitle()).withInList(getList()).withId(getId())
                .withPosition(getPosition()).withBoard(getBoard()).withNumber(getNumber());
    }
}
