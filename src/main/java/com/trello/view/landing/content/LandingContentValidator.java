package com.trello.view.landing.content;

import com.softwareonpurpose.validator4test.Validator;

public class LandingContentValidator extends Validator{
    private static final String DESCRIPTION = "'Landing' content";

    private LandingContentValidator(LandingContentExpected expected, LandingContent actual, Validator parent) {
        super(DESCRIPTION, expected, actual, parent);
    }

    @Override
    protected void executeVerifications() {
    }

    public static LandingContentValidator getInstance(LandingContentExpected expected, LandingContent actual, Validator parent) {
        return new LandingContentValidator(expected, actual, parent);
    }
}
