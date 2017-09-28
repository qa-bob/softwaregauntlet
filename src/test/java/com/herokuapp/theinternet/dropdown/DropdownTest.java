package com.herokuapp.theinternet.dropdown;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.THE_INTERNET, GauntletTest.View.DROPDOWN})
public class DropdownTest extends GauntletTest {
    @DataProvider
    public static Object[][] options() {
        return new Object[][]{
                {DropdownViewValidatable.OPTION_ONE},
                {DropdownViewValidatable.OPTION_TWO}
        };
    }

    @DataProvider
    public static Object[][] multipleOptions() {
        return new Object[][]{
                {DropdownViewValidatable.OPTION_ONE, DropdownViewValidatable.OPTION_TWO},
                {DropdownViewValidatable.OPTION_TWO, DropdownViewValidatable.OPTION_ONE}
        };
    }

    @Test(groups = {TestType.EVT})
    public void smoke() {
        DropdownViewExpected expected = DropdownViewExpected.getInstance();
        DropdownView actual = DropdownView.directNav();
        confirm(DropdownViewValidator.getInstance(expected, actual).validate());
    }

    @Test(groups = {TestType.RELEASE}, dataProvider = "options")
    public void selectOption(String option) {
        DropdownViewExpected expected = DropdownViewExpected.getInstance(option);
        DropdownView actual = DropdownView.directNav().inContent().select(option);
        confirm(DropdownViewValidator.getInstance(expected, actual).validate());
    }

    @Test(groups = {TestType.RELEASE}, dataProvider = "multipleOptions")
    public void selectTwoOptionsSequentially(String firstOption, String secondOption) {
        DropdownViewExpected expected = DropdownViewExpected.getInstance(secondOption);
        DropdownView actual = DropdownView.directNav().inContent().select(firstOption).inContent().select(secondOption);
        confirm(DropdownViewValidator.getInstance(expected, actual).validate());
    }
}
