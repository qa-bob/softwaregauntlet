package com.herokuapp.theinternet.dropdown;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class DropdownTest extends GauntletTest {
    @DataProvider
    public static Object[][] options() {
        return new Object[][]{
                {DropdownViewValidatable.OPTION_ONE},
                {DropdownViewValidatable.OPTION_TWO}
        };
    }

    @Test(groups = {TestType.EVT})
    public void smoke() {
        DropdownViewExpected expected = DropdownViewExpected.getInstance();
        DropdownView actual = DropdownView.directNav();
        confirm(DropdownViewValidator.getInstance(expected, actual).validate());
    }

    @Test(groups = {TestType.RELEASE, TestType.DEV}, dataProvider = "options")
    public void optionOne(String option) {
        DropdownViewExpected expected = DropdownViewExpected.getInstance(option);
        DropdownView actual = DropdownView.directNav().inContent().clickSelect().inContent().clickOption(option);
        confirm(DropdownViewValidator.getInstance(expected, actual).validate());
    }
}
