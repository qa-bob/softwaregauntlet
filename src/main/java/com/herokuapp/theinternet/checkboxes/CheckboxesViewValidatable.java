package com.herokuapp.theinternet.checkboxes;

import com.herokuapp.theinternet.region.footer.TheInternetFooterValidatable;
import com.herokuapp.theinternet.region.header.TheInternetHeaderValidatable;

public interface CheckboxesViewValidatable {
    TheInternetFooterValidatable inFooter();

    TheInternetHeaderValidatable inHeader();

    CheckboxesContentValidatable inContent();
}
