package com.trello.view.card;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.view.card.move.CardMoveModal;

public class CardView extends UiView implements CardViewValidatable {
    private static final String DESCRIPTION = "'Card' view";
    private static final String VIEW_URI = "https://trello.com/c/aMBOItYP/1-tek-user-story";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.CLASS;
    private static final String LOCATOR_VALUE = "window";

    public CardView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static CardView directNav() {
        UiView.instantiateView(CardView.class).load();
        return UiView.expect(CardView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().equals("https://trello.com/c/aMBOItYP/1-tek-user-story");
        confirmed &= getCardTitleElement().isDisplayed();
        return confirmed;
    }

    private UiElement getCardTitleElement() {
        return UiElement.getInstance("Card Title", UiElement.LocatorType.CLASS, "card-detail-title-assist", this.getElement());
    }

    public CardMoveModal clickMove() {
        UiElement.getInstance("'Move' action", UiElement.LocatorType.CLASS, "js-move-card", this.getElement()).click();
        return UiView.expect(CardMoveModal.class);
    }
}
