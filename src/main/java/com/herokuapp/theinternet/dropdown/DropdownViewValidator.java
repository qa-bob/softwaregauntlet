package com.herokuapp.theinternet.dropdown;

import com.herokuapp.theinternet.dropdown.content.DropdownContentValidator;
import com.herokuapp.theinternet.region.footer.TheInternetFooterValidator;
import com.herokuapp.theinternet.region.header.TheInternetHeaderValidator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.validator4test.Validator;

public class DropdownViewValidator extends Validator{
    private static final String DESCRIPTION = "'Dropdown' view";

    private DropdownViewValidator(DropdownViewExpected expected, DropdownView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addChildValidator(TheInternetHeaderValidator.getInstance(expected.inHeader(), actual.inHeader(), this));
        addChildValidator(DropdownContentValidator.getInstance(expected.inContent(), actual.inContent(), this));
        addChildValidator(TheInternetFooterValidator.getInstance(expected.inFooter(), actual.inFooter(), this));
        UiRegion.suppressConstructionLogging(false);
    }

    @Override
    protected void executeVerifications() {

    }

    public static DropdownViewValidator getInstance(DropdownViewExpected expected, DropdownView actual) {
        return new DropdownViewValidator(expected, actual);
    }
}
