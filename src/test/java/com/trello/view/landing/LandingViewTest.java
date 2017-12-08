package com.trello.view.landing;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserDefinition;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.login.LoginView;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.LANDING})
public class LandingViewTest extends GauntletTest {
    private TrelloUserRepository userRepository = TrelloUserRepository.getInstance();

    @DataProvider
    public static Object[][] fromLoginScenarios() {
        return new Object[][]{{TrelloUserDefinition.getInstance()}};
    }

    @Test(groups = {TestType.EVT})
    public void smoke() {
        TrelloUserDefinition anyUser = TrelloUserDefinition.getInstance();
        TrelloUser user = userRepository.query(anyUser);
        LandingViewExpected expected = LandingViewExpected.getInstance();
        given(anyUser);
        when();
        LoginView.directNav().login(user);
        LandingView actual = LandingView.directNav();
        then(LandingViewValidator.getInstance(expected, actual).validate());
    }

    @Test(groups = {TestType.RELEASE}, dataProvider = "fromLoginScenarios")
    public void fromLogin(TrelloUserDefinition userDefinition) {
        setRequirements("User Story #5002");
        TrelloUser user = userRepository.query(userDefinition);
        LandingViewExpected expected = LandingViewExpected.getInstance();
        given(userDefinition);
        when();
        LandingView actual = LoginView.directNav().login(user);
        then(LandingViewValidator.getInstance(expected, actual).validate());
    }
}
