package com.trello.view.card;

import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardValidatable;
import com.trello.data.user.TrelloUser;

public class CardViewExpected implements CardViewValidatable {
    private final TrelloCardValidatable card;
    private final TrelloUser user;

    private CardViewExpected(TrelloUser user, TrelloCardValidatable card) {
        this.user = user;
        this.card = card;
    }

    public static CardViewExpected getInstance(TrelloUser user, TrelloCard card) {
        return new CardViewExpected(user, card);
    }

    @Override
    public String getShowDetailsHref() {
        return "https://trello.com/c/aMBOItYP/1-tek-user-story#";
    }

    @Override
    public String getShowDetailsLink() {
        return "Show Details";
    }

    @Override
    public String addCommentButtonLabel() {
        return "Save";
    }

    @Override
    public Boolean isAddCardIconDisplayed() {
        return true;
    }

    @Override
    public Boolean isEmojiIconDisplayed() {
        return true;
    }

    @Override
    public Boolean isMentionIconDisplayed() {
        return true;
    }

    @Override
    public String getMemberInitials() {
        return user.getInitials();
    }

    @Override
    public String getEditDescriptionHref() {
        return "https://trello.com/c/aMBOItYP/1-tek-user-story#";
    }

    @Override
    public String getList() {
        return card.getList();
    }

    @Override
    public String getListMessage() {
        return String.format("in list %s", card.getList());
    }

    @Override
    public Boolean isCardIconDisplayed() {
        return true;
    }

    @Override
    public String getAddCommentLabel() {
        return "Add Comment";
    }

    @Override
    public Boolean isAddCommentIconDisplayed() {
        return true;
    }
}
