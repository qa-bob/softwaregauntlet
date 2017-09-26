package com.herokuapp.theinternet.dropdown.content;

import com.softwareonpurpose.validator4test.Validator;

public class DropdownContentValidator extends Validator {
    private static final String DESCRIPTION = "Content";
    private final DropdownContent actual;
    private final DropdownContentExpected expected;

    private DropdownContentValidator(DropdownContentExpected expected, DropdownContent actual, Validator parent) {
        super(DESCRIPTION, expected, actual, parent);
        this.actual = actual;
        this.expected = expected;
    }

    public static DropdownContentValidator getInstance(DropdownContentExpected expected, DropdownContent actual, Validator parent) {
        return new DropdownContentValidator(expected, actual, parent);
    }

    @Override
    protected void executeVerifications() {
        verify("Title", expected.getHeading(), actual.getHeading());
        verify("Selected option", expected.getSelectedOption(), actual.getSelectedOption());
    }
}
