package com.herokuapp.theinternet.dropdown;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test
public class DropdownTest extends GauntletTest {
    @Test(groups=TestType.EVT)
    public void smoke(){
        DropdownViewExpected expected = DropdownViewExpected.getInstance();
        DropdownView actual = DropdownView.directNav();
        confirm(DropdownViewValidator.getInstance(expected, actual).validate());
    }
}
