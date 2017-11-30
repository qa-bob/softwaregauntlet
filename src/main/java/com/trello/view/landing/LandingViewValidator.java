package com.trello.view.landing;

import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.validator4test.Validator;
import com.trello.view.landing.content.LandingContentValidator;
import com.trello.view.region.header.TrelloHeaderValidator;

public class LandingViewValidator extends Validator {
    private static final String DESCRIPTION = "'Landing' view";

    private LandingViewValidator(LandingViewExpected expected, LandingView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addChildValidator(TrelloHeaderValidator.getInstance(expected.inHeader(), actual.inHeader(), this));
        addChildValidator(LandingContentValidator.getInstance(expected.inContent(), actual.inContent(), this));
        UiRegion.suppressConstructionLogging(false);
    }

    public static LandingViewValidator getInstance(LandingViewExpected expected, LandingView actual) {
        return new LandingViewValidator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
