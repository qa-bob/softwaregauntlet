package com.herokuapp.theinternet.dropdown;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test
public class DropdownTest extends GauntletTest {
    @Test(groups={TestType.EVT})
    public void smoke(){
        DropdownViewExpected expected = DropdownViewExpected.getInstance();
        DropdownView actual = DropdownView.directNav();
        confirm(DropdownViewValidator.getInstance(expected, actual).validate());
    }

    @Test(groups={TestType.RELEASE})
    public void optionOne(){
        DropdownViewExpected expected = DropdownViewExpected.getInstance(DropdownViewValidatable.OPTION_ONE);
        DropdownView actual = DropdownView.directNav().inContent().clickSelect().inContent().clickOption(DropdownViewValidatable.OPTION_ONE);
        confirm(DropdownViewValidator.getInstance(expected, actual).validate());
    }
}
