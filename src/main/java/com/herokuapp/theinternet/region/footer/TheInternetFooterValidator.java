package com.herokuapp.theinternet.region.footer;

import com.softwareonpurpose.validator4test.Validator;

public class TheInternetFooterValidator extends Validator{
    private static final String DESCRIPTION = "Footer";
    private final TheInternetFooterExpected expected;
    private final TheInternetFooter actual;

    private TheInternetFooterValidator(TheInternetFooterExpected expected, TheInternetFooter actual, Validator parent) {
        super(DESCRIPTION, expected, actual, parent);
        this.expected = expected;
        this.actual = actual;
    }

    @Override
    protected void executeVerifications() {
        verify("Message", expected.getMessage(), actual.getMessage());
        verify("Link Text", expected.getLinkText(), actual.getLinkText());
        verify("'Link' href", expected.getLinkHref(), actual.getLinkHref());
    }

    public static TheInternetFooterValidator getInstance(TheInternetFooterExpected expected, TheInternetFooter actual, Validator parent) {
        return new TheInternetFooterValidator(expected, actual, parent);
    }
}
