package com.trello.view.card;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.TestDataProvider;
import com.trello.data.card.TrelloCard;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.login.LoginView;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.CARD})
public class CardTest extends GauntletTest {
    @Test(groups = {TestType.EVT})
    public void smoke() {
        TrelloUser user = TrelloUserRepository.getInstance().query();
        TrelloCard card = TestDataProvider.getInstance().get();
        CardViewExpected expected = CardViewExpected.getInstance(user, card);
        given(user);
        given(card);
        when();
        LoginView.directNav().login(user);
        CardView actual = CardView.directNav(card);
        then(CardViewValidator.getInstance(expected, actual).validate());
    }
}
