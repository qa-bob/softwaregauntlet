package com.trello.view.board.list.card;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.trello.data.card.TrelloCard;

public class CardRegion extends UiRegion implements CardRegionValidatable {
    private static final String DESCRIPTION = "'Card' region";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.CLASS;
    private static final String LOCATOR_VIEW = "list-card";
    private static final String CARD_URI = "https://trello.com/c";

    private CardRegion(int ordinal, UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VIEW, ordinal, parent));
    }

    public static CardRegion getInstance(int ordinal, UiElement parent) {
        return new CardRegion(ordinal, parent);
    }

    public void click() {
        this.getElement().click();
    }

    public TrelloCard toData() {
        String id = getId();
        String number = getNumber();
        String title = getTitle();
        return TrelloCard.getInstance(id, number, title, null, null, null);
    }

    private String getTitle() {
        return getTitleElement().getText();
    }

    private UiElement getTitleElement() {
        return UiElement.getInstance("Title", UiElement.LocatorType.CLASS, "list-card-title", this.getElement());
    }

    private String getId() {
        String href = this.getElement().getHref();
        int idIndexStart = CARD_URI.length() + 1;
        int idIndexEnd = href.indexOf("/", idIndexStart);
        return href.substring(idIndexStart, idIndexEnd);
    }

    private String getNumber() {
        String href = this.getElement().getHref();
        int idIndexStart = String.format("%s/%s", CARD_URI, getId()).length() + 1;
        int idIndexEnd = href.indexOf("-", idIndexStart);
        return href.substring(idIndexStart, idIndexEnd);
    }
}
