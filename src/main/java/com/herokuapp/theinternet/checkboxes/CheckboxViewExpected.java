package com.herokuapp.theinternet.checkboxes;

import com.herokuapp.theinternet.region.footer.TheInternetFooterExpected;
import com.herokuapp.theinternet.region.footer.TheInternetFooterValidatable;

public class CheckboxViewExpected implements CheckboxViewValidatable {
    private final boolean isCheckbox1Selected;
    private final boolean isCheckbox2Selected;
    private CheckboxViewCopy copy;

    private CheckboxViewExpected(int numberOfTimesCheckbox1Selected, int numberOfTimesCheckbox2Selected) {
        this.isCheckbox1Selected = !(numberOfTimesCheckbox1Selected == 0 || (numberOfTimesCheckbox1Selected % 2) == 0);
        this.isCheckbox2Selected = (numberOfTimesCheckbox2Selected == 0 || (numberOfTimesCheckbox2Selected % 2) == 0);
    }

    static CheckboxViewExpected getInstance(int numberOfTimesCheckbox1Selected, int numberOfTimesCheckbox2Selected) {
        return new CheckboxViewExpected(numberOfTimesCheckbox1Selected, numberOfTimesCheckbox2Selected);
    }

    @Override
    public String getTitle() {
        return getCopy().getTitle();
    }

    private CheckboxViewCopy getCopy() {
        if (copy == null) {
            copy = CheckboxViewCopy.getInstance();
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

    @Override
    public TheInternetFooterExpected inFooter() {
        return TheInternetFooterExpected.getInstance();
    }
}
