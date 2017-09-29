package com.herokuapp.theinternet.checkboxes.content;

import com.softwareonpurpose.validator4test.Validator;

public class CheckboxesContentValidator extends Validator {
    private static final String DESCRIPTION = "Content";
    private final CheckboxesContentExpected expected;
    private final CheckboxesContent actual;

    private CheckboxesContentValidator(CheckboxesContentExpected expected, CheckboxesContent actual, Validator parent) {
        super(DESCRIPTION, expected, actual, parent);
        this.expected = expected;
        this.actual = actual;
    }

    public static CheckboxesContentValidator getInstance(CheckboxesContentExpected expected, CheckboxesContent actual, Validator parent) {
        return new CheckboxesContentValidator(expected, actual, parent);
    }

    @Override
    protected void executeVerifications() {
        verify("Title", expected.getTitle(), actual.getTitle());
        verify("'Checkbox 1' label", expected.getCheckbox1Label(), actual.getCheckbox1Label());
        verify("'Checkbox 2' label", expected.getCheckbox2Label(), actual.getCheckbox2Label());
        verify("Checkbox 1", expected.isCheckbox1Selected(), actual.isCheckbox1Selected());
        verify("Checkbox 2", expected.isCheckbox2Selected(), actual.isCheckbox2Selected());
    }
}
