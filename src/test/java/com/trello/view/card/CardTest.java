package com.trello.view.card;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardProvider;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserProvider;
import com.trello.view.login.LoginView;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.CARD})
public class CardTest extends GauntletTest {
    @Test(groups = {TestType.EVT})
    public void smoke() {
        TrelloUser user = TrelloUserProvider.getInstance().get();
        TrelloCard card = TrelloCardProvider.getInstance().get();
        CardViewExpected expected = CardViewExpected.getInstance(user, card);
        given(user);
        given(card);
        when();
        LoginView.directNav().login(user);
        CardView actual = CardView.directNav();
        then(CardViewValidator.getInstance(expected, actual).validate());
    }
}
