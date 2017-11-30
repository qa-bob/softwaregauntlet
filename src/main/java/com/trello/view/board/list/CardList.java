package com.trello.view.board.list;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.data.card.TrelloCardDefinition;
import com.trello.data.card.TrelloCardValidatable;
import com.trello.view.board.BoardView;
import com.trello.view.board.list.card.CardRegion;
import com.trello.view.card.CardView;

import java.util.List;

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

    public BoardView addCard(TrelloCardValidatable card) {
        clickAddCard();
        setCardTitle(card.getTitle());
        clickSaveButton();
        clickCloseGadget();
        BoardView.directNav();
        return UiView.expect(BoardView.class);
    }

    private void clickCloseGadget() {
        getCloseGadgetElement().click();
    }

    private void clickSaveButton() {
        getSaveButtonElement().click();
    }

    private void setCardTitle(String title) {
        getNewCardTextboxElement().set(title);
    }

    private void clickAddCard() {
        getAddACardElement().click();
    }

    private UiElement getCloseGadgetElement() {
        return UiElement.getInstance("'Close' gadget", UiElement.LocatorType.CLASS, "icon-close", this.getElement());
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

    public CardView clickCard(TrelloCardValidatable card) {
        TrelloCardDefinition cardWithoutList = card.toDefinition().withInList(null);
        List<UiElement> elements = getCardElements();
        int ordinal = 0;
        for (UiElement element : elements) {
            ordinal++;
            CardRegion candidate = CardRegion.getInstance(ordinal, this.getElement());
            if (candidate.toData().equivalent(cardWithoutList)) {
                candidate.click();
                return UiView.expect(CardView.class);
            }
        }
        return null;
    }

    private List<UiElement> getCardElements() {
        return UiElement.getList("Card", UiElement.LocatorType.CLASS, "list-card", this.getElement());
    }

    @Override
    public String getName() {
        return getNameElement().getText();
    }

    private UiElement getNameElement() {
        return UiElement.getInstance("'List' name", UiElement.LocatorType.CLASS, "list-header", this.getElement());
    }
}
