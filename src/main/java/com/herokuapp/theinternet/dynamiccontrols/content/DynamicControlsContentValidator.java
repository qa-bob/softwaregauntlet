package com.herokuapp.theinternet.dynamiccontrols.content;

import com.softwareonpurpose.validator4test.Validator;

public class DynamicControlsContentValidator extends Validator {
    private static final String DESCRIPTION = "Content";
    private final DynamicControlsContentExpected expected;
    private final DynamicControlsContent actual;

    private DynamicControlsContentValidator(DynamicControlsContentExpected expected, DynamicControlsContent actual, Validator parent) {
        super(DESCRIPTION, expected, actual, parent);
        this.expected = expected;
        this.actual = actual;
    }

    public static DynamicControlsContentValidator getInstance(DynamicControlsContentExpected expected, DynamicControlsContent actual, Validator parent) {
        return new DynamicControlsContentValidator(expected, actual, parent);
    }

    @Override
    protected void executeVerifications() {
        verify("Heading", expected.getHeading(), actual.getHeading());
        verify("Description", expected.getContentDescription(), actual.getContentDescription());
        verify("Is button displayed", expected.isButtonDisplayed(), actual.isButtonDisplayed());
        verify("'Button' label", expected.getButtonLabel(), actual.getButtonLabel());
        verify("Is checkbox displayed", expected.isCheckboxDisplayed(), actual.isCheckboxDisplayed());
        verify("'Checkbox' label", expected.getCheckboxLabel(), actual.getCheckboxLabel());
        verify("Is checkbox selected", expected.isCheckboxSelected(), actual.isCheckboxSelected());
    }
}
