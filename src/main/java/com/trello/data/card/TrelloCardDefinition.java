package com.trello.data.card;

public class TrelloCardDefinition implements TrelloCardValidatable {
    private String title;
    private String list;
    private String id;

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

    public TrelloCardDefinition withInList(String list) {
        this.list = list;
        return this;
    }

    TrelloCardDefinition withTitle(String title) {
        this.title = title;
        return this;
    }

    public TrelloCardDefinition withId(String id) {
        this.id = id;
        return this;
    }
}
