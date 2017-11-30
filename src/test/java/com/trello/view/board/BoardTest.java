package com.trello.view.board;

import com.softwareonpurpose.gauntlet.GauntletTest;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserDefinition;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.login.LoginView;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TRELLO, GauntletTest.View.BOARD})
public class BoardTest extends GauntletTest {
    @Test(groups = {TestType.EVT})
    public void smoke() {
        TrelloUserDefinition userDefinition = TrelloUserDefinition.getInstance();
        TrelloUser user = TrelloUserRepository.getInstance().query(userDefinition);
        BoardViewExpected expected = BoardViewExpected.getInstance();
        given(userDefinition);
        when();
        LoginView.directNav().login(user);
        BoardView actual = BoardView.directNav();
        then(BoardViewValidator.getInstance(expected, actual).validate());
    }
}
