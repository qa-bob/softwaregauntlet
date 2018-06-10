package com.trello.view.landing;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.trello.view.landing.content.LandingContentValidator;
import com.trello.view.region.header.TrelloHeaderCalibrator;

public class LandingViewValidator extends Calibrator {
    private static final String DESCRIPTION = "'Landing' view";

    private LandingViewValidator(LandingViewExpected expected, LandingView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addChildCalibrator(TrelloHeaderCalibrator.getInstance(expected.inHeader(), actual.inHeader(), this));
        addChildCalibrator(LandingContentValidator.getInstance(expected.inContent(), actual.inContent(), this));
        UiRegion.suppressConstructionLogging(false);
    }

    public static LandingViewValidator getInstance(LandingViewExpected expected, LandingView actual) {
        return new LandingViewValidator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
