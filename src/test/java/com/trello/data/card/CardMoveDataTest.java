package com.trello.data.card;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.TrelloCardProvider;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserDefinition;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.card.CardView;
import com.trello.view.login.LoginView;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.DataEntity.CARD})
public class CardMoveDataTest extends GauntletTest {

    @DataProvider
    public static Object[][] moveScenarios() {
        String environment = System.getProperty("env");
        String suite_1 = TestType.RELEASE;
        String suite_2 = TestType.SPRINT;
        String testClass = "Card Move Data Test";
        String format = (environment == null || "".equals(environment)) ? "(%s%s and %s) %s" : "(%s %s and %s) %s";
        String TITLE = String.format(format, environment, suite_1, suite_2, testClass);
        String TO_DO = "To Do";
        String IN_PROGRESS = "In Progress";
        String IN_REVIEW = "In Review";
        String DONE = "Done";
        return new Object[][]{
                {TrelloCardDefinition.getInstance().withTitle(TITLE).withInList(TO_DO), IN_PROGRESS}
                , {TrelloCardDefinition.getInstance().withTitle(TITLE).withInList(IN_PROGRESS), IN_REVIEW}
                , {TrelloCardDefinition.getInstance().withTitle(TITLE).withInList(IN_REVIEW), DONE}
        };
    }

    @Test(groups = {TestType.RELEASE, TestType.SPRINT}, dataProvider = "moveScenarios")
    public void fromCardMoveModal(TrelloCardDefinition cardDefinition, String newList) {
        setRequirements("System ID #9004.User Story #5007|System ID #9005.User Story #5008");

        TrelloUserDefinition userDefinition = TrelloUserDefinition.getInstance();
        TrelloUser user = TrelloUserRepository.getInstance().query(userDefinition);
        TrelloCard card = TrelloCardProvider.getInstance().get(cardDefinition);

        TrelloCardDefinition expected = card.toDefinition().withInList(newList);

        given(userDefinition);
        given(cardDefinition);

        when();

        LoginView.directNav().login(user);
        CardView.directNav(card).clickMove().move(newList);

        TrelloCard actual = TrelloCardRepository.getInstance().query(card);

        then(TrelloCardValidator.getInstance(expected, actual).validate());
    }
}
