package com.trello.view.card.move;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.TestDataProvider;
import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardDefinition;
import com.trello.data.card.TrelloCardValidator;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.card.CardView;
import com.trello.view.login.LoginView;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.CARD_MOVE})
public class CardMoveTest extends GauntletTest {
    @Test(groups = {TestType.EVT})
    public void smoke() {
        TrelloUser user = TrelloUserRepository.getInstance().query();
        TrelloCard card = TestDataProvider.getInstance().get();
        CardMoveModalExpected expected = CardMoveModalExpected.getInstance(card);
        given(user);
        given(card);
        when();
        LoginView.directNav().login(user);
        CardMoveModal actual = CardView.directNav(card).clickMove();
        then(CardMoveModalValidator.getInstance(expected, actual).validate());
    }

    @Test(groups = {}, dependsOnMethods = "smoke")
    public void move() {
        TrelloUser user = TrelloUserRepository.getInstance().query();
        TrelloCard card = TestDataProvider.getInstance().get();
        String expectedList = "Done";
        TrelloCardDefinition expected = card.toDefinition().withInList(expectedList);
        given(user);
        given(card);
        when();
        LoginView.directNav().login(user);
        CardView.directNav(card).clickMove().move(expectedList);
        TrelloCard actual = TestDataProvider.getInstance().get(card);
        then(TrelloCardValidator.getInstance(expected, actual).validate());
    }
}
