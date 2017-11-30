package com.trello.view.landing;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserDefinition;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.login.LoginView;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.LANDING})
public class LandingTest extends GauntletTest {
    @DataProvider
    public static Object[][] smokeScenarios() {
        return new Object[][]{{TrelloUserDefinition.getInstance()}};
    }

    @Test(groups = {TestType.EVT}, dataProvider = "smokeScenarios")
    public void smoke(TrelloUserDefinition userDefinition) {
        TrelloUser user = TrelloUserRepository.getInstance().query(userDefinition);
        LandingViewExpected expected = LandingViewExpected.getInstance();
        given(userDefinition);
        when();
        LandingView actual = LoginView.directNav().login(user);
        then(LandingViewValidator.getInstance(expected, actual).validate());
    }
}
