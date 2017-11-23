package com.trello.data.card;

public interface TrelloCardValidatable {
    String getList();

    String getTitle();

    String getId();

    String getPosition();

    String getBoard();
}
