package com.trello.view.card;

import com.trello.data.card.TrelloCardValidatable;
import com.trello.data.user.TrelloUser;

public class CardViewExpected implements CardViewValidatable {
    private final TrelloCardValidatable expectedCard;
    private final TrelloUser expectedUser;
    private CardViewCopy copy;

    private CardViewExpected(TrelloUser expectedUser, TrelloCardValidatable expectedCard) {
        this.expectedUser = expectedUser;
        this.expectedCard = expectedCard;
    }

    public static CardViewExpected getInstance(TrelloUser expectedUser, TrelloCardValidatable expectedCard) {
        return new CardViewExpected(expectedUser, expectedCard);
    }

    @Override
    public String getShowDetailsHref() {
        return getDetailHref();
    }

    private String getDetailHref() {
        String hrefFormat = "https://trello.com/c/%s/%s-%s#";
        return String.format(hrefFormat, expectedCard.getId(), expectedCard.getNumber(), formatForUrl(expectedCard.getTitle()));
    }

    private String formatForUrl(String title) {
        return title.toLowerCase().replace(" ", "-").replace("(", "").replace(")", "");
    }

    @Override
    public String getShowDetailsLink() {
        return getCopy().getShowDetailsLinkCopy();
    }

    private CardViewCopy getCopy() {
        if (copy == null) {
            copy = CardViewCopy.getInstance();
        }
        return copy;
    }

    @Override
    public String addCommentButtonLabel() {
        return getCopy().getCommentButtonLabel();
    }

    @Override
    public String getMemberInitials() {
        return expectedUser.getInitials();
    }

    @Override
    public String getEditDescriptionHref() {
        return getDetailHref();
    }

    @Override
    public String getList() {
        return expectedCard.getList();
    }

    @Override
    public String getListMessage() {
        return String.format("%s %s", getCopy().getListMessage(), expectedCard.getList());
    }

    @Override
    public String getAddCommentLabel() {
        return getCopy().getAddCommentsLabel();
    }

    @Override
    public Boolean isAddCommentIconDisplayed() {
        return true;
    }

    @Override
    public String getId() {
        return expectedCard.getId();
    }

    @Override
    public String getNumber() {
        return expectedCard.getNumber();
    }

    @Override
    public String getTitle() {
        return expectedCard.getTitle();
    }
}
