package com.herokuapp.theinternet.dropdown;

import com.herokuapp.theinternet.dropdown.content.DropdownContentValidatable;
import com.herokuapp.theinternet.region.footer.TheInternetFooterValidatable;
import com.herokuapp.theinternet.region.header.TheInternetHeaderValidatable;

public interface DropdownViewValidatable {
    TheInternetHeaderValidatable inHeader();

    DropdownContentValidatable inContent();

    TheInternetFooterValidatable inFooter();
}
