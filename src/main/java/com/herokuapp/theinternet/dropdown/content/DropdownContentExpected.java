package com.herokuapp.theinternet.dropdown.content;

public class DropdownContentExpected implements DropdownContentValidatable {
    public static DropdownContentExpected getInstance() {
        return new DropdownContentExpected();
    }

    @Override
    public String getSelectedOption() {
        return "Please select an option";
    }

    @Override
    public String getHeading() {
        return "Dropdown List";
    }
}
