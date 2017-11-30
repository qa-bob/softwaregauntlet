package com.trello.data.user;

import com.google.gson.Gson;

public abstract class TrelloUserValidatable {

    abstract String getUsername();

    abstract String getInitials();

    @Override
    public String toString() {
        String details = new Gson().toJson(this);
        return String.format("Trello User: %s", details.replace("{}", "{any}"));
    }

    boolean equivalent(TrelloUserDefinition comparator) {
        if (comparator == null) {
            return true;
        }
        boolean equivalent = isEquivalent(getUsername(), comparator.getUsername());
        equivalent &= isEquivalent(getInitials(), comparator.getInitials());
        return equivalent;
    }

    private boolean isEquivalent(String thisValue, String comparator) {
        return comparator == null || comparator.equals(thisValue);
    }
}
