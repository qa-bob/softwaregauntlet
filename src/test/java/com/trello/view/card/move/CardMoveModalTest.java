package com.trello.view.card.move;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.TestDataProvider;
import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardDefinition;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserDefinition;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.card.CardView;
import com.trello.view.login.LoginView;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.CARD_MOVE})
public class CardMoveModalTest extends GauntletTest {

    @DataProvider
    public static Object[][] smokeScenarios() {
        String TITLE = String.format("(%s) %s", System.getProperty("env"), "Card Move Modal Test");
        return new Object[][]{{TrelloCardDefinition.getInstance().withTitle(TITLE)}};
    }

    @Test(groups = {TestType.EVT}, dataProvider = "smokeScenarios")
    public void smoke(TrelloCardDefinition cardDefinition) {
        setRequirements("User Story #5005|User Story #5006");
        TrelloUserDefinition userDefinition = TrelloUserDefinition.getInstance();
        TrelloUser user = TrelloUserRepository.getInstance().query(userDefinition);
        TrelloCard card = TestDataProvider.getInstance().get();
        CardMoveModalExpected expected = CardMoveModalExpected.getInstance(card);
        given(userDefinition);
        given(cardDefinition);
        when();
        LoginView.directNav().login(user);
        CardMoveModal actual = CardView.directNav(card).clickMove();
        then(CardMoveModalValidator.getInstance(expected, actual).validate());
    }
}
