package com.trello.view.card.move;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardDefinition;
import com.trello.data.card.TrelloCardProvider;
import com.trello.data.card.TrelloCardValidator;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserProvider;
import com.trello.view.login.LoginView;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.CARD_MOVE})
public class CardMoveTest extends GauntletTest {
    @Test(groups = {TestType.DEV})
    public void move() {
        TrelloCard testCard = TrelloCardProvider.getInstance().get();
        String expectedList = "Done";
        TrelloCardDefinition expected = testCard.toDefinition().withInList(expectedList);
        TrelloUser user = TrelloUserProvider.getInstance().get();
        LoginView.directNav().login(user);
        CardMoveModal.directNav().move(expectedList);
        TrelloCard actual = TrelloCardProvider.getInstance().get(testCard);
        then(TrelloCardValidator.getInstance(expected, actual).validate());
    }
}
