package com.trello.view.card.copy;

import com.trello.data.card.TrelloCardValidatable;

public class CardCopyModalExpected implements CardCopyModalValidatable {
    private final TrelloCardValidatable card;

    public CardCopyModalExpected(TrelloCardValidatable card) {
        this.card = card;
    }

    public static CardCopyModalExpected getInstance(TrelloCardValidatable card) {
        return new CardCopyModalExpected(card);
    }
}
