package com.trello.view.region.header;

public class TrelloHeaderExpected implements TrelloHeaderValidatable {

    public static TrelloHeaderExpected getInstance() {
        return new TrelloHeaderExpected();
    }

    @Override
    public Boolean isOpenMemberButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isNotifyButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isInfoButtonDisplayed() {
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
    public Boolean isBoardsButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isLogoDisplayed() {
        return true;
    }
}
