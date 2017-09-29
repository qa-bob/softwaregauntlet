package com.herokuapp.theinternet.dynamiccontrols;

import com.herokuapp.theinternet.dynamiccontrols.content.DynamicControlsContentValidatable;
import com.herokuapp.theinternet.region.footer.TheInternetFooterValidatable;
import com.herokuapp.theinternet.region.header.TheInternetHeaderValidatable;

public interface DynamicControlsViewValidatable {
    TheInternetHeaderValidatable inHeader();

    TheInternetFooterValidatable inFooter();

    DynamicControlsContentValidatable inContent();
}
