package com.trello.view.region.header;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class TrelloHeader extends UiRegion implements TrelloHeaderValidatable {
    private static final String DESCRIPTION = "'Header' region";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.ID;
    private static final String LOCATOR_VALUE = "body-board-view";

    private TrelloHeader(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static TrelloHeader getInstance(UiElement parent) {
        return new TrelloHeader(parent);
    }

    @Override
    public String getOpenMemberButtonLabel() {
        return UiElement.getInstance("'Open members button' label", UiElement.LocatorType.CLASS, "member-initials",
                getOpenMembersButtonElement()).getText();
    }

    private UiElement getOpenMembersButtonElement() {
        return UiElement.getInstance("'Open members' button", UiElement.LocatorType.CLASS, "header-avatar", this
                .getElement());
    }

    @Override
    public Boolean isOpenMemberButtonDisplayed() {
        return getOpenMembersButtonElement().isDisplayed();
    }

    @Override
    public Boolean isNotifyButtonDisplayed() {
        return UiElement.getInstance("'Notifications' button", UiElement.LocatorType.CLASS, "header-notifications",
                this.getElement()).isDisplayed();
    }

    @Override
    public Boolean isInfoButtonDisplayed() {
        return UiElement.getInstance("'Open information' button", UiElement.LocatorType.CLASS, "header-info", this
                .getElement()).isDisplayed();
    }

    @Override
    public Boolean isCreateButtonDisplayed() {
        return UiElement.getInstance("'Add menu' button", UiElement.LocatorType.CLASS, "js-open-add-menu", this
                .getElement()).isDisplayed();
    }

    @Override
    public Boolean isSearchIconDisplayed() {
        return UiElement.getInstance("'Search' icon", UiElement.LocatorType.CLASS, "header-search-icon", this
                .getElement()).isDisplayed();
    }

    @Override
    public Boolean isSearchDisplayed() {
        return UiElement.getInstance("Search", UiElement.LocatorType.CLASS, "header-search-input", this.getElement())
                .isDisplayed();
    }

    @Override
    public String getBoardsButtonLabel() {
        return getBoardsButtonElement().getText();
    }

    private UiElement getBoardsButtonElement() {
        String description = "'Boards' button";
        return UiElement.getInstance(description, UiElement.LocatorType.CLASS, "header-boards", this.getElement());
    }

    @Override
    public Boolean isBoardsButtonDisplayed() {
        return getBoardsButtonElement().isDisplayed();
    }

    @Override
    public Boolean isBackupButtonDisplayed() {
        return UiElement.getInstance("'Back' button", UiElement.LocatorType.CLASS, "header-back-button", this
                .getElement()).isDisplayed();
    }

    @Override
    public Boolean isLogoDisplayed() {
        return UiElement.getInstance("Logo", UiElement.LocatorType.CLASS, "header-logo", this.getElement())
                .isDisplayed();
    }
}
