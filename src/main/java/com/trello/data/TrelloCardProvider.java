package com.trello.data;

import com.softwareonpurpose.uinavigator.UiRegion;
import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardDefinition;
import com.trello.data.card.TrelloCardRepository;
import com.trello.data.card.TrelloCardValidatable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrelloCardProvider {
    private static TrelloCardProvider provider;
    private TrelloCardRepository repository;
    private Logger logger;

    private TrelloCardProvider() {
    }

    public static TrelloCardProvider getInstance() {
        if (provider == null) {
            provider = new TrelloCardProvider();
        }
        return provider;
    }

    public TrelloCard get(TrelloCardValidatable card) {
        UiRegion.suppressConstructionLogging(true);
        TrelloCard identified = getRepository().query(card);
        if (identified == null) {
            identified = addCard(card);
        }
        UiRegion.suppressConstructionLogging(false);
        getLogger().info("TEST DATA ACQUIRED:");
        getLogger().info(identified.toString());
        getLogger().info("");
        return identified;
    }

    private TrelloCardRepository getRepository() {
        if (repository == null) {
            UiRegion.suppressConstructionLogging(true);
            repository = TrelloCardRepository.getInstance();
            UiRegion.suppressConstructionLogging(true);
        }
        return repository;
    }

    private TrelloCard addCard(TrelloCardValidatable card) {
        TrelloCard identified;
        String title = card.getTitle() == null ? "TEK User Story" : card.getTitle();
        String list = card.getList() == null ? "To Do" : card.getList();
        UiRegion.suppressConstructionLogging(true);
        identified = getRepository().add(TrelloCardDefinition.getInstance().withInList(list).withTitle(title));
        UiRegion.suppressConstructionLogging(false);
        return identified;
    }

    private Logger getLogger() {
        if (logger == null) {
            logger = LoggerFactory.getLogger("");
        }
        return logger;
    }

    public TrelloCard get() {
        UiRegion.suppressConstructionLogging(true);
        TrelloCard identifiedCard = get(TrelloCardDefinition.getInstance());
        UiRegion.suppressConstructionLogging(false);
        return identifiedCard;
    }
}
