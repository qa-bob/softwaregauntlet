package com.trello.view.card.move;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.card.*;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserProvider;
import com.trello.view.card.CardView;
import com.trello.view.login.LoginView;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.CARD_MOVE})
public class CardMoveTest extends GauntletTest {
    @Test(groups = {TestType.EVT})
    public void smoke() {
        TrelloUser user = TrelloUserProvider.getInstance().get();
        TrelloCard card = TrelloCardProvider.getInstance().get();
        CardMoveModalExpected expected = CardMoveModalExpected.getInstance(card);
        LoginView.directNav().login(user);
        CardMoveModal actual = CardView.directNav().clickMove();
        then(CardMoveModalValidator.getInstance(expected, actual).validate());
    }

    @Test(groups = {TestType.DEV}, dependsOnMethods = "smoke")
    public void move() {
        TrelloUser user = TrelloUserProvider.getInstance().get();
        TrelloCard card = TrelloCardProvider.getInstance().get();
        String expectedList = "Done";
        TrelloCardDefinition expected = card.toDefinition().withInList(expectedList);
        LoginView.directNav().login(user);
        CardView.directNav().clickMove().move(expectedList);
        TrelloCard actual = TrelloCardProvider.getInstance().get(card);
        then(TrelloCardValidator.getInstance(expected, actual).validate());
    }
}
