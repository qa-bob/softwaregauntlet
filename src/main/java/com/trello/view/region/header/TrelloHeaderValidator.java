package com.trello.view.region.header;

import com.softwareonpurpose.validator4test.Validator;

public class TrelloHeaderValidator extends Validator {
    private static final String DESCRIPTION = "'Header' region";
    private final static String IS_DISPLAYED = "Is %s displayed?";
    private final TrelloHeaderValidatable expected;
    private final TrelloHeaderValidatable actual;

    private TrelloHeaderValidator(TrelloHeaderExpected expected, TrelloHeader actual, Validator parent) {
        super(DESCRIPTION, expected, actual, parent);
        this.expected = expected;
        this.actual = actual;
    }

    public static TrelloHeaderValidator getInstance(TrelloHeaderExpected expected, TrelloHeader actual, Validator
            parent) {
        return new TrelloHeaderValidator(expected, actual, parent);
    }

    @Override
    protected void executeVerifications() {
        String logoVerification = String.format(IS_DISPLAYED, "logo");
        String boardsButtonVerification = String.format(IS_DISPLAYED, "'Boards' button");
        String searchVerification = String.format(IS_DISPLAYED, "Search");
        String searchIconVerification = String.format(IS_DISPLAYED, "'Search' icon");
        String createButtonVerification = String.format(IS_DISPLAYED, "'Create' button");
        String infoButtonVerification = String.format(IS_DISPLAYED, "'Open information' button");
        String notifyButtonVerification = String.format(IS_DISPLAYED, "'Notifications' button");
        String membersButtonVerification = String.format(IS_DISPLAYED, "'Open member menu' button");

        verify(logoVerification, expected.isLogoDisplayed(), actual.isLogoDisplayed());
        verify(boardsButtonVerification, expected.isBoardsButtonDisplayed(), actual.isBoardsButtonDisplayed());
        verify(searchVerification, expected.isSearchDisplayed(), actual.isSearchDisplayed());
        verify(searchIconVerification, expected.isSearchIconDisplayed(), actual.isSearchIconDisplayed());
        verify(createButtonVerification, expected.isCreateButtonDisplayed(), actual.isCreateButtonDisplayed());
        verify(infoButtonVerification, expected.isInfoButtonDisplayed(), actual.isInfoButtonDisplayed());
        verify(notifyButtonVerification, expected.isNotifyButtonDisplayed(), actual.isNotifyButtonDisplayed());
        verify(membersButtonVerification, expected.isOpenMemberButtonDisplayed(), actual.isOpenMemberButtonDisplayed());
    }
}
