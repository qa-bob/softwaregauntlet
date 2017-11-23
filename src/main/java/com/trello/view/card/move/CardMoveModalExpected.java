package com.trello.view.card.move;

import com.trello.data.card.TrelloCardValidatable;

public class CardMoveModalExpected implements CardMoveModalValidatable {
    private final TrelloCardValidatable expectedCard;

    private CardMoveModalExpected(TrelloCardValidatable expectedCard) {
        this.expectedCard = expectedCard;
    }

    public static CardMoveModalExpected getInstance(TrelloCardValidatable expectedCard) {
        return new CardMoveModalExpected(expectedCard);
    }

    @Override
    public String getTitle() {
        return "Move Card";
    }

    @Override
    public String getMoveButtonLabel() {
        return "Move";
    }

    @Override
    public String getPosition() {
        return expectedCard.getPosition();
    }

    @Override
    public String getPositionLabel() {
        return "Position";
    }

    @Override
    public String getList() {
        return expectedCard.getList();
    }

    @Override
    public String getListLabel() {
        return "List";
    }

    @Override
    public String getBoard() {
        return expectedCard.getBoard();
    }

    @Override
    public String getBoardLabel() {
        return "Board";
    }
}
