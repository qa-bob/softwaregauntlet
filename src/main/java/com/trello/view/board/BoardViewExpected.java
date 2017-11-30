package com.trello.view.board;

import com.trello.view.board.list.CardListExpected;
import com.trello.view.region.header.TrelloHeaderExpected;

public class BoardViewExpected implements BoardViewValidatable {
    public static BoardViewExpected getInstance() {
        return new BoardViewExpected();
    }

    @Override
    public CardListExpected inList(String name) {
        return CardListExpected.getInstance();
    }

    @Override
    public TrelloHeaderExpected inHeader() {
        return TrelloHeaderExpected.getInstance();
    }
}
