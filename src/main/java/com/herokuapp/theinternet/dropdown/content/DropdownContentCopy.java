package com.herokuapp.theinternet.dropdown.content;

public class DropdownContentCopy {
    public static DropdownContentCopy getInstance() {
        return new DropdownContentCopy();
    }

    String getOption(String option) {
        return option == null ? "Please select an option" : String.format("Option %s", option);
    }
}
