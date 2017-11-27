package com.trello.data;

import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardDefinition;
import com.trello.data.card.TrelloCardRepository;
import com.trello.data.card.TrelloCardValidatable;

public class TestDataProvider {
    private static TestDataProvider provider;
    private final TrelloCardRepository repository;

    private TestDataProvider() {
        repository = TrelloCardRepository.getInstance();
    }

    public static TestDataProvider getInstance() {
        if (provider == null) {
            provider = new TestDataProvider();
        }
        return provider;
    }

    public TrelloCard get(TrelloCardValidatable card) {
        TrelloCard identified = repository.get(card);
        return identified == null ? repository.add(TrelloCardDefinition.getInstance().withInList("To Do").withTitle
                ("TEK User Story")) : identified;
    }

    public TrelloCard get() {
        TrelloCard identified = repository.get();
        return identified == null ? repository.add(TrelloCardDefinition.getInstance().withInList("To Do").withTitle
                ("TEK User Story")) : identified;
    }
}
