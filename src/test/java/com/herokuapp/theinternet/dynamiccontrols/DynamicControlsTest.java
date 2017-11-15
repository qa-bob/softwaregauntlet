package com.herokuapp.theinternet.dynamiccontrols;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.THE_INTERNET, GauntletTest.View.DYNAMIC_CONTROLS})
public class DynamicControlsTest extends GauntletTest {
    @Test(groups = {TestType.EVT})
    public void smoke() {
        setRequirements(null);
        DynamicControlsViewExpected expected = DynamicControlsViewExpected.getDefaultInstance();
        when();
        DynamicControlsView actual = DynamicControlsView.directNav();
        then(DynamicControlsViewValidator.getInstance(expected, actual).validate());
    }

    @Test(groups = {TestType.SPRINT}, dependsOnMethods = "smoke")
    public void transitionOnRemoval() {
        setRequirements("SysID9020.US8024|SysID9025.US8050|US8034");
        DynamicControlsViewExpected expected = DynamicControlsViewExpected.getRemovalTransitionInstance();
        when();
        DynamicControlsView actual = DynamicControlsView.directNav().inContent().clickRemove();
        then(DynamicControlsViewValidator.getInstance(expected, actual).validate());
    }
}
