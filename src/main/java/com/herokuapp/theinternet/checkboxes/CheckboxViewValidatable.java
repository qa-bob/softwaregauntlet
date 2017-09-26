package com.herokuapp.theinternet.checkboxes;

import com.herokuapp.theinternet.region.footer.TheInternetFooterValidatable;

public interface CheckboxViewValidatable {
    String getTitle();

    Boolean isCheckbox1Selected();

    Boolean isCheckbox2Selected();

    String getCheckbox1Label();

    String getCheckbox2Label();

    TheInternetFooterValidatable inFooter();
}
