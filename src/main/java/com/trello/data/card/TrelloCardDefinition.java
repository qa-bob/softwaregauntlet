package com.trello.data.card;

public class TrelloCardDefinition extends TrelloCardValidatable {
    private String title;
    private String list;
    private String id;
    private String board;
    private String position;

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

    public TrelloCardDefinition withInList(String list) {
        this.list = list;
        return this;
    }

    TrelloCardDefinition withTitle(String title) {
        this.title = title;
        return this;
    }

    public TrelloCardValidatable withList(String list) {
        this.list = list;
        return this;
    }
}
