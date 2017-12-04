package com.trello.view.card.move;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.view.card.CardView;

public class CardMoveModal extends UiView implements CardMoveModalValidatable {
    private static final String LOCATOR_VALUE = "pop-over";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.CLASS;
    private static final String DESCRIPTION = "'Move Card' modal";
    private static final String VIEW_URI = "https://trello.com/c/aMBOItYP/1-tek-user-story";

    public CardMoveModal() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().contains(VIEW_URI);
        confirmed &= getTitleElement().isDisplayed();
        confirmed &= "Move Card".equals(getTitle());
        return confirmed;
    }

    @Override
    public String getTitle() {
        return getTitleElement().getText();
    }

    @Override
    public String getMoveButtonLabel() {
        return getMoveButtonElement().getText();
    }

    @Override
    public String getPosition() {
        return getPositionElement().getText();
    }

    private UiElement getPositionElement() {
        return UiElement.getInstance("Position", UiElement.LocatorType.CLASS, "js-pos-value", this.getElement());
    }

    @Override
    public String getPositionLabel() {
        return getPositionLabelElement().getText();
    }

    private UiElement getPositionLabelElement() {
        return UiElement.getInstance("'Position' label", UiElement.LocatorType.CLASS, "label", 3, this.getElement());
    }

    @Override
    public String getList() {
        return UiElement.getInstance("List", UiElement.LocatorType.CLASS, "js-list-value", this.getElement()).getText();
    }

    @Override
    public String getListLabel() {
        return getListLabelElement().getText();
    }

    private UiElement getListLabelElement() {
        return UiElement.getInstance("'List' label", UiElement.LocatorType.CLASS, "label", 2, this.getElement());
    }

    @Override
    public String getBoard() {
        return getBoardElement().getText();
    }

    private UiElement getBoardElement() {
        return UiElement.getInstance("Board", UiElement.LocatorType.CLASS, "js-board-value", this.getElement());
    }

    @Override
    public String getBoardLabel() {
        return getBoardLabelElement().getText();
    }

    private UiElement getBoardLabelElement() {
        return UiElement.getInstance("'Board' label", UiElement.LocatorType.CLASS, "label", 1, this.getElement());
    }

    private UiElement getTitleElement() {
        return UiElement.getInstance("Title", UiElement.LocatorType.CLASS, "pop-over-header-title");
    }

    public CardView move(String list) {
        getListSelectElement().set(list);
        CardMoveModal modal = UiView.expect(CardMoveModal.class);
        modal.clickMoveButton();
        return UiView.expect(CardView.class);
    }

    private void clickMoveButton() {
        getMoveButtonElement().click();
    }

    private UiElement getMoveButtonElement() {
        return UiElement.getInstance("'Move' button", UiElement.LocatorType.CLASS, "js-submit", this.getElement());
    }

    private UiElement getListSelectElement() {
        return UiElement.getInstance("'List' select", UiElement.LocatorType.CLASS, "js-select-list", this.getElement());
    }
}
