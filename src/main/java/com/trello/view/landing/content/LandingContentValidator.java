package com.trello.view.landing.content;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class LandingContentValidator extends Calibrator {
    private static final String DESCRIPTION = "'Landing' content";

    private LandingContentValidator(LandingContentExpected expected, LandingContent actual, Calibrator parent) {
        super(DESCRIPTION, expected, actual, parent);
    }

    @Override
    protected void executeVerifications() {
    }

    public static LandingContentValidator getInstance(LandingContentExpected expected, LandingContent actual, Calibrator parent) {
        return new LandingContentValidator(expected, actual, parent);
    }
}
