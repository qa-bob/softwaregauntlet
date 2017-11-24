package com.trello.view.region.header;

class TrelloHeaderCopy {
    private static final String BOARDS_BUTTON_LABEL = "Boards";

    public static TrelloHeaderCopy getInstance() {
        return new TrelloHeaderCopy();
    }

    String getBoardsButtonLabel() {
        return BOARDS_BUTTON_LABEL;
    }
}
