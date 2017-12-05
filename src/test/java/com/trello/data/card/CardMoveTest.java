package com.trello.data.card;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.TestDataProvider;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserDefinition;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.card.CardView;
import com.trello.view.login.LoginView;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.Database.TRELLO})
public class CardMoveTest extends GauntletTest {

    @DataProvider
    public static Object[][] moveScenarios() {
        String TITLE = "Card Move Data Test";
        String TO_DO = "To Do";
        String IN_PROGRESS = "In Progress";
        String IN_REVIEW = "In Review";
        String DONE = "Done";
        return new Object[][]{{TrelloCardDefinition.getInstance().withTitle(TITLE).withInList(TO_DO), IN_PROGRESS},
                {TrelloCardDefinition.getInstance().withTitle(TITLE).withInList(IN_PROGRESS), IN_REVIEW},
                {TrelloCardDefinition.getInstance().withTitle(TITLE).withInList(IN_REVIEW), DONE}};
    }

    @Test(groups = {TestType.RELEASE, TestType.SPRINT}, dataProvider = "moveScenarios")
    public void fromCardMoveModal(TrelloCardDefinition cardDefinition, String newList) {
        setRequirements("System ID #9004.User Story #5007|System ID #9005.User Story #5008");
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
