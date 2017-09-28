package com.herokuapp.theinternet.dynamiccontrols;

import com.herokuapp.theinternet.region.footer.TheInternetFooterExpected;
import com.herokuapp.theinternet.region.header.TheInternetHeaderExpected;

public class DynamicControlsViewExpected implements DynamicControlsViewValidatable {
    public static DynamicControlsViewExpected getDefaultInstance() {
        return new DynamicControlsViewExpected();
    }

    @Override
    public TheInternetHeaderExpected inHeader() {
        return TheInternetHeaderExpected.getInstance();
    }

    @Override
    public TheInternetFooterExpected inFooter() {
        return TheInternetFooterExpected.getInstance();
    }
}
