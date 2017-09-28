package com.herokuapp.theinternet.dropdown.content;

public class DropdownContentExpected implements DropdownContentValidatable {
    private final String selectedOption;
    private DropdownContentCopy copy;

    private DropdownContentExpected(String option) {
        selectedOption = getContent().getOption(option);
    }

    private DropdownContentCopy getContent() {
        if(copy==null){
            copy=DropdownContentCopy.getInstance();
        }
        return copy;
    }

    public static DropdownContentExpected getInstance(String option) {
        return new DropdownContentExpected(option);
    }

    @Override
    public String getSelectedOption() {
        return selectedOption;
    }

    @Override
    public String getHeading() {
        return "Dropdown List";
    }

    @Override
    public Boolean isDefaultOptionEnabled() {
        return false;
    }
}
