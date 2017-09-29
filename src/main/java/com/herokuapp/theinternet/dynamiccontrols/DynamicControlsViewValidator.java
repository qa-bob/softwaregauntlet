package com.herokuapp.theinternet.dynamiccontrols;

import com.herokuapp.theinternet.dynamiccontrols.content.DynamicControlsContentValidator;
import com.herokuapp.theinternet.region.footer.TheInternetFooterValidator;
import com.herokuapp.theinternet.region.header.TheInternetHeaderValidator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.validator4test.Validator;

public class DynamicControlsViewValidator extends Validator {
    private static final String DESCRIPTION = "Dynamic Controls";

    private DynamicControlsViewValidator(DynamicControlsViewExpected expected, DynamicControlsView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addChildValidator(TheInternetHeaderValidator.getInstance(expected.inHeader(), actual.inHeader(), this));
        addChildValidator(DynamicControlsContentValidator.getInstance(expected.inContent(), actual.inContent(), this));
        addChildValidator(TheInternetFooterValidator.getInstance(expected.inFooter(), actual.inFooter(), this));
        UiRegion.suppressConstructionLogging(false);
    }

    public static DynamicControlsViewValidator getInstance(DynamicControlsViewExpected expected, DynamicControlsView actual) {
        return new DynamicControlsViewValidator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
