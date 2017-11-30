package com.trello.view.board.list;

public class CardListExpected implements CardListValidatable {
    private final String name;

    private CardListExpected(String name) {
        this.name = name;
    }

    public static CardListExpected getInstance() {
        return new CardListExpected("To Do");
    }

    @Override
    public String getName() {
        return name;
    }
}
