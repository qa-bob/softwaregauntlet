package com.trello.data.card;

import com.softwareonpurpose.uinavigator.UiHost;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.board.BoardView;
import com.trello.view.login.LoginView;

import java.util.ArrayList;
import java.util.List;

public class TrelloCardRepository {
    private static TrelloCardRepository repository;
    private final List<TrelloCard> cards;
    private List<Integer> queueNumbers = new ArrayList<>();

    private TrelloCardRepository() {
        TrelloUser user = TrelloUserRepository.getInstance().query();
        LoginView.directNav().login(user);
        BoardView board = BoardView.directNav();
        cards = board.getCards();
        board.logout();
        UiHost.quitInstance();
    }

    public static TrelloCardRepository getInstance() {
        if (repository == null) {
            repository = new TrelloCardRepository();
        }
        return repository;
    }

    public TrelloCard get(TrelloCardValidatable card) {
        Integer queueNumber = takeANumber();
        waitYourTurn(queueNumber);
        for (TrelloCard candidate : cards) {
            if (candidate.equivalent(card)) {
                cards.remove(candidate);
                discardNumber(queueNumber);
                return candidate;
            }
        }
        return null;
    }

    private void discardNumber(Integer queueNumber) {
        queueNumbers.remove(queueNumber);
    }

    private void waitYourTurn(Integer queueNumber) {
        //noinspection StatementWithEmptyBody
        while (!queueNumber.equals(queueNumbers.get(0))) ;
    }

    private Integer takeANumber() {
        Integer queueNumber = queueNumbers.size() + 1;
        queueNumbers.add(queueNumber);
        return queueNumber;
    }

    public TrelloCard add(TrelloCardDefinition card) {
        TrelloUser user = TrelloUserRepository.getInstance().query();
        LoginView.directNav().login(user);
        String listName = "To Do";
        TrelloCard identifiedCard = BoardView.directNav().inList(listName).addCard(card).inList(listName).clickCard
                (card).toData();
        BoardView.directNav().logout();
        UiHost.quitInstance();
        return identifiedCard;
    }

    public TrelloCard get() {
        return get(null);
    }
}
