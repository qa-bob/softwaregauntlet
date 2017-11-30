package com.trello.view.card.move;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.TestDataProvider;
import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardDefinition;
import com.trello.data.card.TrelloCardRepository;
import com.trello.data.card.TrelloCardValidator;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserDefinition;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.card.CardView;
import com.trello.view.login.LoginView;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.CARD_MOVE})
public class CardMoveTest extends GauntletTest {
    @DataProvider
    public static Object[][] moveScenarios() {
        return new Object[][]{{TrelloCardDefinition.getInstance().withInList("To Do"), "In Progress"},
                {TrelloCardDefinition.getInstance().withInList("In Progress"), "In Review"}, {TrelloCardDefinition
                .getInstance().withInList("In Review"), "Done"}};
    }

    @DataProvider
    public static Object[][] smokeScenarios() {
        return new Object[][]{{TrelloCardDefinition.getInstance()}};
    }

    @Test(groups = {TestType.EVT}, dataProvider = "smokeScenarios")
    public void smoke(TrelloCardDefinition cardDefinition) {
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

    @Test(groups = {TestType.RELEASE}, dataProvider = "moveScenarios", dependsOnMethods = "smoke")
    public void move(TrelloCardDefinition cardDefinition, String newList) {
        TrelloUserDefinition userDefinition = TrelloUserDefinition.getInstance();
        TrelloUser user = TrelloUserRepository.getInstance().query(userDefinition);
        TrelloCard card = TestDataProvider.getInstance().get(cardDefinition);
        TrelloCardDefinition expected = card.toDefinition().withInList(newList);
        given(userDefinition);
        given(cardDefinition);
        when();
        LoginView.directNav().login(user);
        CardView.directNav(card).clickMove().move(newList);
        TrelloCard actual = TrelloCardRepository.getInstance().query(expected);
        then(TrelloCardValidator.getInstance(expected, actual).validate());
    }
}
