package com.herokuapp.theinternet.dynamiccontrols;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.THE_INTERNET, GauntletTest.View.DYNAMIC_CONTROLS})
public class DynamicControlsTest extends GauntletTest {
    @Test(groups = {TestType.EVT, TestType.DEV})
    public void smoke() {
        DynamicControlsViewExpected expected = DynamicControlsViewExpected.getDefaultInstance();
        when();
        DynamicControlsView actual = DynamicControlsView.directNav();
        then(DynamicControlsViewValidator.getInstance(expected, actual).validate());
    }
}
