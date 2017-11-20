package com.trello.data.card;

public class TrelloCard implements TrelloCardValidatable{
    private final String title;
    private final String list;
    private final String id;

    private TrelloCard(String id, String title, String list) {
        this.id = id;
        this.title = title;
        this.list = list;
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

    public TrelloCardDefinition toDefinition() {
        return TrelloCardDefinition.getInstance().withTitle(title).withInList(list);
    }

    static TrelloCard getInstance() {
        return new TrelloCard("#1", "TEK User Story", "Acceptance");
    }
}
