package com.trello.view.landing;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserProvider;
import com.trello.view.login.LoginView;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.LANDING})
public class LandingTest extends GauntletTest {
    @Test(groups={TestType.EVT})
    public void smoke(){
        TrelloUser user = TrelloUserProvider.getInstance().get();
        LandingViewExpected expected = LandingViewExpected.getInstance();
        LandingView actual = LoginView.directNav().login(user);
        confirm(LandingViewValidator.getInstance(expected, actual).validate());
    }
}
