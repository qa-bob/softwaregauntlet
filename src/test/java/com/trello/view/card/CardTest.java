package com.trello.view.card;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.TestDataProvider;
import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardDefinition;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserDefinition;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.login.LoginView;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.CARD})
public class CardTest extends GauntletTest {
    @DataProvider
    public static Object[][] smokeScenarios() {
        return new Object[][]{{TrelloCardDefinition.getInstance()}};
    }

    @Test(groups = {TestType.EVT}, dataProvider = "smokeScenarios")
    public void smoke(TrelloCardDefinition testCardDefinition) {
        TrelloUserDefinition userDefinition = TrelloUserDefinition.getInstance();
        TrelloUser user = TrelloUserRepository.getInstance().query(userDefinition);
        TrelloCard card = TestDataProvider.getInstance().get(testCardDefinition);
        CardViewExpected expected = CardViewExpected.getInstance(user, card);
        given(userDefinition);
        given(testCardDefinition);
        when();
        LoginView.directNav().login(user);
        CardView actual = CardView.directNav(card);
        then(CardViewValidator.getInstance(expected, actual).validate());
    }
}
