package com.herokuapp.theinternet.checkboxes.content;

import com.softwareonpurpose.validator4test.Validator;

public class CheckboxesContentValidator extends Validator {
    private static final String DESCRIPTION = "Content";

    private CheckboxesContentValidator(CheckboxesContentExpected expected, CheckboxesContent actual, Validator parent) {
        super(DESCRIPTION, expected, actual, parent);
    }

    public static CheckboxesContentValidator getInstance(CheckboxesContentExpected expected, CheckboxesContent actual, Validator parent) {
        return new CheckboxesContentValidator(expected, actual, parent);
    }

    @Override
    protected void executeVerifications() {

    }
}
