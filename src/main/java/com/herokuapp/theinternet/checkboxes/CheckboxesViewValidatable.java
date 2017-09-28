package com.herokuapp.theinternet.checkboxes;

import com.herokuapp.theinternet.region.footer.TheInternetFooterValidatable;
import com.herokuapp.theinternet.region.header.TheInternetHeaderValidatable;

public interface CheckboxesViewValidatable {
    String getTitle();

    Boolean isCheckbox1Selected();

    Boolean isCheckbox2Selected();

    String getCheckbox1Label();

    String getCheckbox2Label();

    TheInternetFooterValidatable inFooter();

    TheInternetHeaderValidatable inHeader();

    CheckboxesContentValidatable inContent();
}
