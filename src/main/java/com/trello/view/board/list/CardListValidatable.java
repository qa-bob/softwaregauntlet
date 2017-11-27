package com.trello.view.board.list;

import com.trello.data.card.TrelloCardValidatable;
import com.trello.view.board.BoardViewValidatable;

public interface CardListValidatable {
    BoardViewValidatable addCard(TrelloCardValidatable card);

    String getName();
}
