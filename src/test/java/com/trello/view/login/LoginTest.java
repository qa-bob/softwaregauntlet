package com.trello.view.login;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.LOGIN})
public class LoginTest extends GauntletTest {
    @Test(groups = {TestType.EVT})
    public void smoke() {
        LoginViewExpected expected = LoginViewExpected.getInstance();
        LoginView actual = LoginView.directNav();
        then(LoginViewValidator.getInstance(expected, actual).validate());
    }
}
