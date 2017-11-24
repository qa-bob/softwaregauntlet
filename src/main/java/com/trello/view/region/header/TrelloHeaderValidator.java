package com.trello.view.region.header;

import com.softwareonpurpose.validator4test.Validator;

public class TrelloHeaderValidator extends Validator {
    private static final String DESCRIPTION = "'Footer' region";
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
        verify("Is logo displayed?", expected.isLogoDisplayed(), actual.isLogoDisplayed());
        verify("Is 'Boards' button displayed?", expected.isBoardsButtonDisplayed(), actual.isBoardsButtonDisplayed());
        verify("Is 'Search' displayed?", expected.isSearchDisplayed(), actual.isSearchDisplayed());
        verify("Is 'Search' icon displayed?", expected.isSearchIconDisplayed(), actual.isSearchIconDisplayed());
        verify("Is 'Create' button displayed?", expected.isCreateButtonDisplayed(), actual.isCreateButtonDisplayed());
        verify("Is 'Open information' button displayed?", expected.isOpenInformationButtonDisplayed(), actual
                .isOpenInformationButtonDisplayed());
        verify("Is 'Notifications' button displayed?", expected.isNotificationsButtonDisplayed(), actual
                .isNotificationsButtonDisplayed());
        verify("Is 'Open member menu' button displayed?", expected.isOpenMemberButtonDisplayed(), actual
                .isOpenMemberButtonDisplayed());
    }
}
