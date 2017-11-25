package com.trello.view.card;

import com.trello.copy.TrelloCopy;

class CardViewCopy {
    private TrelloCopy source;

    public static CardViewCopy getInstance() {
        return new CardViewCopy();
    }

    String getShowDetailsLinkCopy() {
        return getSource().getShowDetails();
    }

    private TrelloCopy getSource() {
        if (source == null) {
            source = TrelloCopy.getInstance();
        }
        return source;
    }

    String getCommentButtonLabel() {
        return getSource().getSave();
    }

    String getListMessage() {
        return getSource().getInList();
    }

    String getAddCommentsLabel() {
        return getSource().getAddComment();
    }
}
