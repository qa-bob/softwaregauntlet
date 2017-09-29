package com.herokuapp.theinternet.checkboxes;

import com.herokuapp.theinternet.checkboxes.content.CheckboxesContentValidator;
import com.herokuapp.theinternet.region.footer.TheInternetFooterValidator;
import com.herokuapp.theinternet.region.header.TheInternetHeaderValidator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.validator4test.Validator;

public class CheckboxesViewValidator extends Validator {
    private final CheckboxesViewExpected expected;
    private final CheckboxesView actual;

    private CheckboxesViewValidator(CheckboxesViewExpected expected, CheckboxesView actual) {
        super("Checkbox View", expected, actual);
        this.expected = expected;
        this.actual = actual;
        UiRegion.suppressConstructionLogging(true);
        addChildValidator(TheInternetHeaderValidator.getInstance(expected.inHeader(), actual.inHeader(), this));
        addChildValidator(CheckboxesContentValidator.getInstance(expected.inContent(), actual.inContent(), this));
        addChildValidator(TheInternetFooterValidator.getInstance(expected.inFooter(), actual.inFooter(), this));
        UiRegion.suppressConstructionLogging(false);
    }

    static CheckboxesViewValidator getInstance(CheckboxesViewExpected expected, CheckboxesView actual) {
        return new CheckboxesViewValidator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
    }
}
