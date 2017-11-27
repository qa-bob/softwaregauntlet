package com.trello.view.card;

import com.softwareonpurpose.validator4test.Validator;

public class CardViewValidator extends Validator {
    private static final String DESCRIPTION = "'Card' view";
    private final CardViewValidatable expected;
    private final CardViewValidatable actual;

    private CardViewValidator(CardViewExpected expected, CardView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static CardViewValidator getInstance(CardViewExpected expected, CardView actual) {
        return new CardViewValidator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        String commentVerifyDesc = "Is 'Add comment' icon displayed?";
        verify("'List' label", expected.getListMessage(), actual.getListMessage());
        verify("List", expected.getList(), actual.getList());
        verify("'Edit description' href", expected.getEditDescriptionHref(), actual.getEditDescriptionHref());
        verify(commentVerifyDesc, expected.isAddCommentIconDisplayed(), actual.isAddCommentIconDisplayed());
        verify("'Add comment' label", expected.getAddCommentLabel(), actual.getAddCommentLabel());
        verify("Member initials", expected.getMemberInitials(), actual.getMemberInitials());
        verify("'Add comment' button label", expected.addCommentButtonLabel(), actual.addCommentButtonLabel());
        verify("'Show details' link", expected.getShowDetailsLink(), actual.getShowDetailsLink());
        verify("'Show details' href", expected.getShowDetailsHref(), actual.getShowDetailsHref());
    }
}
