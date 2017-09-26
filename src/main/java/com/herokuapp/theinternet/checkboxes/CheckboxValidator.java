package com.herokuapp.theinternet.checkboxes;

import com.herokuapp.theinternet.region.footer.TheInternetFooterValidator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.validator4test.Validator;

public class CheckboxValidator extends Validator {
    private final CheckboxViewExpected expected;
    private final CheckboxView actual;

    private CheckboxValidator(CheckboxViewExpected expected, CheckboxView actual) {
        super("Checkbox View", expected, actual);
        this.expected = expected;
        this.actual = actual;
        UiRegion.suppressConstructionLogging(true);
        addChildValidator(TheInternetFooterValidator.getInstance(expected.inFooter(), actual.inFooter(), this));
        UiRegion.suppressConstructionLogging(false);
    }

    @Override
    protected void executeVerifications() {
        verify("Title", expected.getTitle(), actual.getTitle());
        verify("'Checkbox 1' label", expected.getCheckbox1Label(), actual.getCheckbox1Label());
        verify("'Checkbox 2' label", expected.getCheckbox2Label(), actual.getCheckbox2Label());
        verify("Checkbox 1", expected.isCheckbox1Selected(), actual.isCheckbox1Selected());
        verify("Checkbox 2", expected.isCheckbox2Selected(), actual.isCheckbox2Selected());
    }

    static CheckboxValidator getInstance(CheckboxViewExpected expected, CheckboxView actual) {
        return new CheckboxValidator(expected, actual);
    }
}
