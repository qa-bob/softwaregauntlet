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
public class CardViewTest extends GauntletTest {

    @DataProvider
    public static Object[][] smokeScenarios() {
        return new Object[][]{{TrelloCardDefinition.getInstance()}};
    }

    @DataProvider
    public static Object[][] moveScenarios() {
        String TO_DO = "To Do";
        String IN_PROGRESS = "In Progress";
        String IN_REVIEW = "In Review";
        String DONE = "Done";
        String CARD_VIEW_TEST = "Card View Test";
        return new Object[][]{{TrelloCardDefinition.getInstance().withInList(TO_DO).withTitle(CARD_VIEW_TEST),
                IN_PROGRESS}, {TrelloCardDefinition.getInstance().withInList(IN_PROGRESS).withTitle(CARD_VIEW_TEST),
                IN_REVIEW}, {TrelloCardDefinition.getInstance().withInList(IN_REVIEW).withTitle(CARD_VIEW_TEST), DONE}};
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

    @Test(groups = {TestType.SPRINT, TestType.RELEASE}, dataProvider = "moveScenarios")
    public void fromCardMoveModal(TrelloCardDefinition cardDefinition, String newList) {
        this.setRequirements("SysID #9001.User Story #5001|SysId #9001.User Story #5003|User Story #5004");
        TrelloUserDefinition userDefinition = TrelloUserDefinition.getInstance();
        TrelloUser user = TrelloUserRepository.getInstance().query(userDefinition);
        TrelloCard card = TestDataProvider.getInstance().get(cardDefinition);
        TrelloCardDefinition expectedCard = card.toDefinition().withInList(newList);
        CardViewExpected expected = CardViewExpected.getInstance(user, expectedCard);
        given(userDefinition);
        given(cardDefinition);
        when();
        LoginView.directNav().login(user);
        CardView actual = CardView.directNav(card).clickMove().move(newList);
        then(CardViewValidator.getInstance(expected, actual).validate());
    }
}
