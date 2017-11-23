package com.trello.view.card;

public interface CardViewValidatable {
    String getShowDetailsHref();

    String getShowDetailsLink();

    String addCommentButtonLabel();

    Boolean isAddCardIconDisplayed();

    Boolean isEmojiIconDisplayed();

    Boolean isMentionIconDisplayed();

    String getMemberInitials();

    String getEditDescriptionHref();

    String getList();

    String getListMessage();

    Boolean isCardIconDisplayed();

    String getAddCommentLabel();

    Boolean isAddCommentIconDisplayed();
}
