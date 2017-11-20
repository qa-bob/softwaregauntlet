package com.trello.data.card;

import java.util.Collections;
import java.util.List;

public class TrelloCardProvider {
    public static TrelloCardProvider getInstance() {
        return new TrelloCardProvider();
    }

    public TrelloCard get(TrelloCard card) {
        for (TrelloCard candidate : getCards()) {
            if (candidate.getId().equals(card.getId())) {
                return candidate;
            }
        }
        return null;
    }

    private List<TrelloCard> getCards() {
        return Collections.singletonList(TrelloCard.getInstance("#1", "TEK User Story", "Done"));
    }

    public TrelloCard get() {
        return TrelloCard.getInstance();
    }
}
