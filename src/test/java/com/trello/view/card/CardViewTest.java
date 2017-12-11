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
    private static String testClass = "Card View Test";
    private static String environment = System.getProperty("env");
    private TrelloUserRepository userRepository = TrelloUserRepository.getInstance();
    private TestDataProvider testDataProvider = TestDataProvider.getInstance();

    @DataProvider
    public static Object[][] smokeScenario() {
        String suite = TestType.EVT;
        String format = (environment == null || "".equals(environment)) ? "(%s%s) %s" : "(%s %s) %s";
        final String CARD_TITLE = String.format(format, environment, suite, testClass);
        return new Object[][]{
                {TrelloCardDefinition.getInstance().withTitle(CARD_TITLE)}
        };
    }

    @DataProvider
    public static Object[][] moveScenarios() {
        String suite_1 = TestType.RELEASE;
        String suite_2 = TestType.SPRINT;
        String format = (environment == null || "".equals(environment)) ? "(%s%s and %s) %s" : "(%s %s and %s) %s";
        final String CARD_TITLE = String.format(format, environment, suite_1, suite_2, testClass);
        String TO_DO = "To Do";
        String IN_PROGRESS = "In Progress";
        String IN_REVIEW = "In Review";
        String DONE = "Done";
        return new Object[][]{
                {TrelloCardDefinition.getInstance().withInList(TO_DO).withTitle(CARD_TITLE), IN_PROGRESS}
                , {TrelloCardDefinition.getInstance().withInList(IN_PROGRESS).withTitle(CARD_TITLE), IN_REVIEW}
                , {TrelloCardDefinition.getInstance().withInList(IN_REVIEW).withTitle(CARD_TITLE), DONE}
        };
    }

    @Test(groups = {TestType.EVT, TestType.DEV, TestType.PRODUCTION}, dataProvider = "smokeScenario")
    public void smoke(TrelloCardDefinition testCardDefinition) {
        TrelloUserDefinition userDefinition = TrelloUserDefinition.getInstance();
        TrelloUser user = userRepository.query(userDefinition);
        TrelloCard card = testDataProvider.get(testCardDefinition);
        CardViewExpected expected = CardViewExpected.getInstance(user, card);
        given(userDefinition);
        given(testCardDefinition);
        when();
        LoginView.directNav().login(user);
        CardView actual = CardView.directNav(card);
        then(CardViewValidator.getInstance(expected, actual).validate());
    }

    @Test(groups = {TestType.SPRINT, TestType.RELEASE}, dataProvider = "moveScenarios", dependsOnMethods = "smoke")
    public void fromCardMoveModal(TrelloCardDefinition cardDefinition, String newList) {
        this.setRequirements("SysID #9001.User Story #5001|SysId #9001.User Story #5003|User Story #5004");
        TrelloUserDefinition userDefinition = TrelloUserDefinition.getInstance();
        TrelloUser user = userRepository.query(userDefinition);
        TrelloCard card = testDataProvider.get(cardDefinition);
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
