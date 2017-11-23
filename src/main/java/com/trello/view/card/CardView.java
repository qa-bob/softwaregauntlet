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
        confirmed &= getMoveElement().isDisplayed();
        return confirmed;
    }

    public CardMoveModal clickMove() {
        getMoveElement().click();
        return UiView.expect(CardMoveModal.class);
    }

    private UiElement getMoveElement() {
        return UiElement.getInstance("'Move' action", UiElement.LocatorType.CLASS, "js-move-card", this.getElement());
    }

    @Override
    public String getShowDetailsHref() {
        return getShowDetailsLinkElement().getHref();
    }

    private UiElement getShowDetailsLinkElement() {
        return UiElement.getInstance("Show details", UiElement.LocatorType.CLASS, "js-show-details", this.getElement());
    }

    @Override
    public String getShowDetailsLink() {
        return getShowDetailsLinkElement().getText();
    }

    private UiElement getAddCommentButtonElement() {
        return UiElement.getInstance("'Add comment' button", UiElement.LocatorType.CLASS, "js-add-comment", this.getElement());
    }

    @Override
    public String addCommentButtonLabel() {
        return getAddCommentButtonElement().getText();
    }

    @Override
    public Boolean isAddCardIconDisplayed() {
        return getIconElement("Add card", "icon-card").isDisplayed();
    }

    private UiElement getIconElement(String iconName, String locatorValue) {
        return UiElement.getInstance(String.format("'%s' icon", iconName), UiElement.LocatorType.CLASS, locatorValue, getCommentElement());
    }

    private UiElement getCommentElement() {
        return UiElement.getInstance("Comment", UiElement.LocatorType.CLASS, "comment-frame", this.getElement());
    }

    @Override
    public Boolean isEmojiIconDisplayed() {
        return getIconElement("Add emoji", "icon-emoji").isDisplayed();
    }

    @Override
    public Boolean isMentionIconDisplayed() {
        return getIconElement("Mention member", "icon-mention").isDisplayed();
    }

    @Override
    public String getMemberInitials() {
        return UiElement.getInstance("Member initials", UiElement.LocatorType.CLASS, "member-initials", this.getElement()).getText();
    }

    @Override
    public String getEditDescriptionHref() {
        return getEditDescriptionLinkElement().getHref();
    }

    private UiElement getEditDescriptionLinkElement() {
        return UiElement.getInstance("Edit description", UiElement.LocatorType.CLASS, "js-edit-desc", this.getElement());
    }

    @Override
    public String getList() {
        return UiElement.getInstance("List", UiElement.LocatorType.CLASS, "js-open-move-from-header", getCurrentListElement()).getText();
    }

    private UiElement getCurrentListElement() {
        return UiElement.getInstance("Current list", UiElement.LocatorType.CLASS, "js-current-list", this.getElement());
    }

    @Override
    public String getListMessage() {
        return getCurrentListElement().getText();
    }

    @Override
    public Boolean isCardIconDisplayed() {
        return UiElement.getInstance("'Card' icon", UiElement.LocatorType.CLASS, "icon-card", getHeaderElement()).isDisplayed();
    }

    private UiElement getHeaderElement() {
        return UiElement.getInstance("Header", UiElement.LocatorType.CLASS, "window-header", this.getElement());
    }

    @Override
    public String getAddCommentLabel() {
        return UiElement.getInstance("'Add comment' label", UiElement.LocatorType.TAG, "h3", getAddCommentSectionElement()).getText();
    }

    private UiElement getAddCommentSectionElement() {
        return UiElement.getInstance("'Add comment' section", UiElement.LocatorType.CLASS, "add-comment-section", this.getElement());
    }

    @Override
    public Boolean isAddCommentIconDisplayed() {
        return UiElement.getInstance("'Add comment' icon", UiElement.LocatorType.CLASS, "icon-comment", this.getElement()).isDisplayed();
    }
}
