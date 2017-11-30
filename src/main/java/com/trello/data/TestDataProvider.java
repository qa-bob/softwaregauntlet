package com.trello.data;

import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardDefinition;
import com.trello.data.card.TrelloCardRepository;
import com.trello.data.card.TrelloCardValidatable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDataProvider {
    private static TestDataProvider provider;
    private final TrelloCardRepository repository;
    private Logger logger;

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
        TrelloCard identified = repository.query(card);
        if (identified == null) {
            String title = card.getTitle() == null ? "TEK User Story" : card.getTitle();
            String list = card.getList() == null ? "To Do" : card.getList();
            identified = repository.add(TrelloCardDefinition.getInstance().withInList(list).withTitle(title));
        }
        getLogger().info("TEST CARD ACQUIRED:");
        getLogger().info("");
        return identified;
    }

    private Logger getLogger() {
        if (logger == null) {
            logger = LoggerFactory.getLogger("");
        }
        return logger;
    }

    public TrelloCard get() {
        return get(TrelloCardDefinition.getInstance());
    }
}
