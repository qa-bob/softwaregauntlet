package com.trello.view.card.move;

public class CardMoveModalCopy {
    private static final String MOVE_MODAL_TITLE = "Move Card";
    private static final String MOVE_BUTTON_LABEL = "Move";
    private static final String POSITION_LABEL = "Position";
    private static final String LIST_LABEL = "List";
    private static final String BOARD_LABEL = "Board";

    public static CardMoveModalCopy getInstance() {
        return new CardMoveModalCopy();
    }

    public String getTitle() {
        return MOVE_MODAL_TITLE;
    }

    String getMoveButtonLabel() {
        return MOVE_BUTTON_LABEL;
    }

    String getPositionLabel() {
        return POSITION_LABEL;
    }

    String getListLabel() {
        return LIST_LABEL;
    }

    String getBoardLabel() {
        return BOARD_LABEL;
    }
}
