package com.trello.view.board;

import com.trello.view.board.list.CardListValidatable;
import com.trello.view.region.header.TrelloHeaderValidatable;

public interface BoardViewValidatable {
    CardListValidatable inList(String name);

    TrelloHeaderValidatable inHeader();
}
