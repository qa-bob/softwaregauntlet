package com.herokuapp.theinternet.dynamiccontrols;

import com.herokuapp.theinternet.dynamiccontrols.content.DynamicControlsContentExpected;
import com.herokuapp.theinternet.region.footer.TheInternetFooterExpected;
import com.herokuapp.theinternet.region.header.TheInternetHeaderExpected;

public class DynamicControlsViewExpected implements DynamicControlsViewValidatable {
    static DynamicControlsViewExpected getDefaultInstance() {
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

    @Override
    public DynamicControlsContentExpected inContent() {
        return DynamicControlsContentExpected.getInstance();
    }
}
