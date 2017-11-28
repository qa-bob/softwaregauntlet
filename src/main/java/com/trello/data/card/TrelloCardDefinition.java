package com.trello.data.card;

public class TrelloCardDefinition extends TrelloCardValidatable {
    private String title;
    private String list;
    private String id;
    private String board;
    private String position;
    private String number;

    public static TrelloCardDefinition getInstance() {
        return new TrelloCardDefinition();
    }

    @Override
    public String getList() {
        return list;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public String getBoard() {
        return board;
    }

    @Override
    public String getNumber() {
        return number;
    }

    public TrelloCardDefinition withInList(String list) {
        this.list = list;
        return this;
    }

    public TrelloCardDefinition withTitle(String title) {
        this.title = title;
        return this;
    }

    TrelloCardDefinition withId(String id) {
        this.id = id;
        return this;
    }

    TrelloCardDefinition withPosition(String position) {
        this.position = position;
        return this;
    }

    TrelloCardDefinition withBoard(String board) {
        this.board = board;
        return this;
    }

    TrelloCardDefinition withNumber(String number) {
        this.number = number;
        return this;
    }
}
