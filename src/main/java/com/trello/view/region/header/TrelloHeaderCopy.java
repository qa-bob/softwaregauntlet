package com.trello.view.region.header;

import com.trello.copy.TrelloCopy;

class TrelloHeaderCopy {
    private static TrelloCopy source;

    private static TrelloCopy getSource() {
        if(source==null){
            source = TrelloCopy.getInstance();
        }
        return source;
    }

    public static TrelloHeaderCopy getInstance() {
        return new TrelloHeaderCopy();
    }

    String getBoardsButtonLabel() {
        return getSource().getBoards();
    }
}
