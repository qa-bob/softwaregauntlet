package com.trello.data.user;

import com.google.gson.Gson;

public abstract class TrelloUserValidatable {
    abstract String getPassword();

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
        boolean equivalent = comparator.getUsername() == null || comparator.getUsername().equals(getUsername());
        equivalent &= comparator.getInitials() == null || comparator.getInitials().equals(getInitials());
        return equivalent;
    }
}
