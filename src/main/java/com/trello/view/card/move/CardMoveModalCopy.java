package com.trello.view.card.move;

import com.trello.copy.TrelloCopy;

public class CardMoveModalCopy {
    private TrelloCopy source;

    public static CardMoveModalCopy getInstance() {
        return new CardMoveModalCopy();
    }

    public String getTitle() {
        return String.format("%s %s", getSource().getMove(), getSource().getCard());
    }

    private TrelloCopy getSource() {
        if (source == null) {
            source = TrelloCopy.getInstance();
        }
        return source;
    }

    String getMoveButtonLabel() {
        return getSource().getMove();
    }

    String getPositionLabel() {
        return getSource().getPosition();
    }

    String getListLabel() {
        return getSource().getList();
    }

    String getBoardLabel() {
        return getSource().getBoard();
    }
}
