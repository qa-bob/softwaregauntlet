package com.herokuapp.theinternet.dropdown;

import com.herokuapp.theinternet.dropdown.content.DropdownContentExpected;
import com.herokuapp.theinternet.region.footer.TheInternetFooterExpected;
import com.herokuapp.theinternet.region.header.TheInternetHeaderExpected;

public class DropdownViewExpected implements DropdownViewValidatable {
    private final String optionValue;

    private DropdownViewExpected(String option) {
        optionValue = option;
    }

    public static DropdownViewExpected getInstance() {
        return new DropdownViewExpected(null);
    }

    public static DropdownViewExpected getInstance(String option) {
        return new DropdownViewExpected(option);
    }

    @Override
    public TheInternetHeaderExpected inHeader() {
        return TheInternetHeaderExpected.getInstance();
    }

    @Override
    public DropdownContentExpected inContent() {
        return DropdownContentExpected.getInstance(optionValue);
    }

    @Override
    public TheInternetFooterExpected inFooter() {
        return TheInternetFooterExpected.getInstance();
    }
}
