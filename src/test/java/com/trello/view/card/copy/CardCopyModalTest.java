package com.trello.view.card.copy;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.TrelloCardProvider;
import com.trello.data.card.TrelloCardValidatable;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserDefinition;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.card.CardView;
import com.trello.view.login.LoginView;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.TestSubject.COPY})
public class CardCopyModalTest extends GauntletTest {
    @Test(groups = {TestType.EVT, TestType.DEV})
    public void smoke(){
        TrelloUserDefinition userDefinition = TrelloUserDefinition.getInstance();
        TrelloUser user = TrelloUserRepository.getInstance().query(userDefinition);
        TrelloCardValidatable card = TrelloCardProvider.getInstance().get();
        CardCopyModalExpected expected = CardCopyModalExpected.getInstance(card);
        given(user);
        given(card);
        when();
        LoginView.directNav().login(user);
        CardCopyModal actual = CardView.directNav(card).clickCopy();
        then(CardCopyModalValidator.getInstance(expected, actual).validate());
    }
}
