package com.trello.view.region.header;

public interface TrelloHeaderValidatable {
    String getOpenMemberButtonLabel();

    Boolean isOpenMemberButtonDisplayed();

    Boolean isNotifyButtonDisplayed();

    Boolean isInfoButtonDisplayed();

    Boolean isCreateButtonDisplayed();

    Boolean isSearchIconDisplayed();

    Boolean isSearchDisplayed();

    String getBoardsButtonLabel();

    Boolean isBoardsButtonDisplayed();

    Boolean isBackupButtonDisplayed();

    Boolean isLogoDisplayed();
}
