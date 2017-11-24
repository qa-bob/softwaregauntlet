package com.trello.view.card;

class CardViewCopy {
    private static final String SHOW_DETAILS_LINK = "Show Details";
    private static final String COMMENT_BUTTON_LABEL = "Save";
    private static final String IN_LIST = "in list";
    private static final String ADD_COMMENTS_LABEL = "Add Comment";

    String getShowDetailsLinkCopy() {
        return SHOW_DETAILS_LINK;
    }

    public static CardViewCopy getInstance() {
        return new CardViewCopy();
    }

    String getCommentButtonLabel() {
        return COMMENT_BUTTON_LABEL;
    }

    String getListMessage() {
        return IN_LIST;
    }

    String getAddCommentsLabel() {
        return ADD_COMMENTS_LABEL;
    }
}
