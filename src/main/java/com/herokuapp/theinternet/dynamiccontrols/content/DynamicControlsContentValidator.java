package com.herokuapp.theinternet.dynamiccontrols.content;

import com.softwareonpurpose.validator4test.Validator;

public class DynamicControlsContentValidator extends Validator {
    private static final String DESCRIPTION = "Content";

    private DynamicControlsContentValidator(DynamicControlsContentExpected expected, DynamicControlsContent actual, Validator parent) {
        super(DESCRIPTION, expected, actual, parent);
    }

    public static DynamicControlsContentValidator getInstance(DynamicControlsContentExpected expected, DynamicControlsContent actual, Validator parent) {
        return new DynamicControlsContentValidator(expected, actual, parent);
    }

    @Override
    protected void executeVerifications() {

    }
}
