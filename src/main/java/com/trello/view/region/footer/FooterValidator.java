package com.trello.view.region.footer;

import com.softwareonpurpose.validator4test.Validator;

public class FooterValidator extends Validator {
    private static final String DESCRIPTION = "'Footer' region";

    private FooterValidator(FooterExpected expected, Footer actual, Validator parent) {
        super(DESCRIPTION, expected, actual, parent);
    }

    @Override
    protected void executeVerifications() {

    }

    public static FooterValidator getInstance(FooterExpected expected, Footer actual, Validator parent) {
        return new FooterValidator(expected, actual, parent);
    }
}
