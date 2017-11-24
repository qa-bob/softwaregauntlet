package com.trello.view.card.move;

import com.trello.data.card.TrelloCardValidatable;

public class CardMoveModalExpected implements CardMoveModalValidatable {
    private final TrelloCardValidatable expectedCard;
    private CardMoveModalCopy copy;

    private CardMoveModalExpected(TrelloCardValidatable expectedCard) {
        this.expectedCard = expectedCard;
    }

    public static CardMoveModalExpected getInstance(TrelloCardValidatable expectedCard) {
        return new CardMoveModalExpected(expectedCard);
    }

    @Override
    public String getTitle() {
        return getCopy().getTitle();
    }

    private CardMoveModalCopy getCopy() {
        if (copy == null) {
            copy = CardMoveModalCopy.getInstance();
        }
        return copy;
    }

    @Override
    public String getMoveButtonLabel() {
        return getCopy().getMoveButtonLabel();
    }

    @Override
    public String getPosition() {
        return expectedCard.getPosition();
    }

    @Override
    public String getPositionLabel() {
        return getCopy().getPositionLabel();
    }

    @Override
    public String getList() {
        return expectedCard.getList();
    }

    @Override
    public String getListLabel() {
        return getCopy().getListLabel();
    }

    @Override
    public String getBoard() {
        return expectedCard.getBoard();
    }

    @Override
    public String getBoardLabel() {
        return getCopy().getBoardLabel();
    }
}
