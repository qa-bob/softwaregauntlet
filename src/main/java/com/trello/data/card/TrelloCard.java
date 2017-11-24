package com.trello.data.card;

public class TrelloCard extends TrelloCardValidatable {
    private final String title;
    private final String list;
    private final String id;
    private final String board;
    private final String position;

    private TrelloCard(String id, String title, String board, String list, String position) {
        this.id = id;
        this.title = title;
        this.list = list;
        this.board = board;
        this.position = position;
    }

    static TrelloCard getInstance() {
        return new TrelloCard("#1", "TEK User Story", "Application Project", "Acceptance", "1");
    }

    public static TrelloCard getInstance(String id, String title, String board, String list, String position) {
        return new TrelloCard(id, title, board, list, position);
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

    public TrelloCardDefinition toDefinition() {
        return TrelloCardDefinition.getInstance().withTitle(title).withInList(list);
    }
}
