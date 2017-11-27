package com.trello.data;

import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardRepository;

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

    public TrelloCard get(TrelloCard card) {
        TrelloCard identified = repository.get(card);
        while (identified == null) {
            identified = repository.add(card);
        }
        return identified;
    }

    public TrelloCard get() {
        return repository.get();
    }
}
