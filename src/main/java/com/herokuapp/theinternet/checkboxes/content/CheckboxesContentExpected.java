package com.herokuapp.theinternet.checkboxes.content;

import com.herokuapp.theinternet.checkboxes.CheckboxesContentValidatable;
import com.herokuapp.theinternet.checkboxes.CheckboxesViewCopy;

public class CheckboxesContentExpected implements CheckboxesContentValidatable {
    private final Boolean isCheckbox1Selected;
    private final Boolean isCheckbox2Selected;
    private CheckboxesViewCopy copy;

    private CheckboxesContentExpected(Boolean isCheckbox1Selected, Boolean isCheckbox2Selected) {
        this.isCheckbox1Selected = isCheckbox1Selected;
        this.isCheckbox2Selected = isCheckbox2Selected;
    }

    public static CheckboxesContentExpected getInstance(boolean isCheckbox1Selected, boolean isCheckbox2Selected) {
        return new CheckboxesContentExpected(isCheckbox1Selected, isCheckbox2Selected);
    }

    @Override
    public String getTitle() {
        return getCopy().getTitle();
    }

    private CheckboxesViewCopy getCopy() {
        if (copy == null) {
            copy = CheckboxesViewCopy.getInstance();
        }
        return copy;
    }

    @Override
    public Boolean isCheckbox1Selected() {
        return isCheckbox1Selected;
    }

    @Override
    public Boolean isCheckbox2Selected() {
        return isCheckbox2Selected;
    }

    @Override
    public String getCheckbox1Label() {
        return "checkbox 1";
    }

    @Override
    public String getCheckbox2Label() {
        return "checkbox 2";
    }
}
