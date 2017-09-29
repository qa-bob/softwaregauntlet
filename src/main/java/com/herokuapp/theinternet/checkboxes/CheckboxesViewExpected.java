package com.herokuapp.theinternet.checkboxes;

import com.herokuapp.theinternet.checkboxes.content.CheckboxesContentExpected;
import com.herokuapp.theinternet.region.footer.TheInternetFooterExpected;
import com.herokuapp.theinternet.region.header.TheInternetHeaderExpected;

public class CheckboxesViewExpected implements CheckboxesViewValidatable {
    private final boolean isCheckbox1Selected;
    private final boolean isCheckbox2Selected;

    private CheckboxesViewExpected(int numberOfTimesCheckbox1Selected, int numberOfTimesCheckbox2Selected) {
        this.isCheckbox1Selected = !(numberOfTimesCheckbox1Selected == 0 || (numberOfTimesCheckbox1Selected % 2) == 0);
        this.isCheckbox2Selected = (numberOfTimesCheckbox2Selected == 0 || (numberOfTimesCheckbox2Selected % 2) == 0);
    }

    static CheckboxesViewExpected getInstance(int numberOfTimesCheckbox1Selected, int numberOfTimesCheckbox2Selected) {
        return new CheckboxesViewExpected(numberOfTimesCheckbox1Selected, numberOfTimesCheckbox2Selected);
    }

    @Override
    public TheInternetFooterExpected inFooter() {
        return TheInternetFooterExpected.getInstance();
    }

    @Override
    public TheInternetHeaderExpected inHeader() {
        return TheInternetHeaderExpected.getInstance();
    }

    @Override
    public CheckboxesContentExpected inContent() {
        return CheckboxesContentExpected.getInstance(isCheckbox1Selected, isCheckbox2Selected);
    }
}
