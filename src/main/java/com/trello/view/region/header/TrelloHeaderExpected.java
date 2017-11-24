package com.trello.view.region.header;

public class TrelloHeaderExpected implements TrelloHeaderValidatable {
    public static TrelloHeaderExpected getInstance() {
        return new TrelloHeaderExpected();
    }

    @Override
    public String getOpenMemberButtonLabel() {
        return "T";
    }

    @Override
    public Boolean isOpenMemberButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isNotificationsButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isOpenInformationButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isCreateButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isSearchIconDisplayed() {
        return true;
    }

    @Override
    public Boolean isSearchDisplayed() {
        return true;
    }

    @Override
    public String getBoardsButtonLabel() {
        return "Boards";
    }

    @Override
    public Boolean isBoardsButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isBackupButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isLogoDisplayed() {
        return true;
    }
}
