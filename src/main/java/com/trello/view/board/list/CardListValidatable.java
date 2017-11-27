package com.trello.view.board.list;

import com.trello.data.card.TrelloCard;
import com.trello.view.board.BoardViewValidatable;
import com.trello.view.card.CardView;

public interface CardListValidatable {
    BoardViewValidatable addCard(TrelloCard card);

    CardView clickCard(TrelloCard card);

    String getName();
}
