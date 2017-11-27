package com.trello.view.board;

import com.trello.view.board.list.CardListValidatable;

public interface BoardViewValidatable {
    CardListValidatable inList(String name);
}
