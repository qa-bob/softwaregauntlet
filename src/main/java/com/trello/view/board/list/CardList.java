package com.trello.view.board.list;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.data.card.TrelloCard;
import com.trello.view.board.BoardView;
import com.trello.view.card.CardView;

public class CardList extends UiRegion implements CardListValidatable {
    private static final String DESCRIPTION = "'Card list' region";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.CLASS;
    private static final String LOCATOR_VALUE = "list";

    private CardList(int ordinal, UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, ordinal, parent));
    }

    public static CardList getInstance(int ordinal, UiElement parent) {
        return new CardList(ordinal, parent);
    }

    @Override
    public BoardView addCard(TrelloCard card) {
        getAddACardElement().click();
        getNewCardTextboxElement().set(card.getTitle());
        getSaveButtonElement().click();
        return UiView.expect(BoardView.class);
    }

    private UiElement getSaveButtonElement() {
        return UiElement.getInstance("'Save' button", UiElement.LocatorType.CLASS, "confirm", this.getElement());
    }

    private UiElement getNewCardTextboxElement() {
        String description = "'New card' textbox";
        String locatorValue = "list-card-composer-textarea";
        return UiElement.getInstance(description, UiElement.LocatorType.CLASS, locatorValue, this.getElement());
    }

    private UiElement getAddACardElement() {
        String description = "'Add a card' link";
        return UiElement.getInstance(description, UiElement.LocatorType.CLASS, "open-card-composer", this.getElement());
    }

    @Override
    public CardView clickCard(TrelloCard card) {
        return null;
    }

    @Override
    public String getName() {
        return UiElement.getInstance("'List' name", UiElement.LocatorType.CLASS, "list-header", this.getElement())
                .getText();
    }
}
