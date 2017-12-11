package com.trello.view.login;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.LOGIN})
public class LoginViewTest extends GauntletTest {
    @Test(groups = {TestType.EVT, TestType.PRODUCTION})
    public void smoke() {
        LoginViewExpected expected = LoginViewExpected.getInstance();
        when();
        LoginView actual = LoginView.directNav();
        then(LoginViewValidator.getInstance(expected, actual).validate());
    }
}
