package com.trello.view.board.list.card;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.view.card.CardView;

public class CardRegion extends UiRegion implements CardRegionValidatable {
    private static final String DESCRIPTION = "'Card' region";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.CLASS;
    private static final String LOCATOR_VIEW = "list-card";

    private CardRegion(int ordinal, UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VIEW, ordinal, parent));
    }

    public static CardRegion getInstance(int ordinal, UiElement parent) {
        return new CardRegion(ordinal, parent);
    }

    public CardView click() {
        this.getElement().click();
        return UiView.expect(CardView.class);
    }
}
