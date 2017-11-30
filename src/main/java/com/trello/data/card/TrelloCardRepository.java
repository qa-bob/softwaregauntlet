package com.trello.data.card;

import com.softwareonpurpose.uinavigator.UiRegion;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserDefinition;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.board.BoardView;
import com.trello.view.card.CardView;
import com.trello.view.login.LoginView;

import java.util.ArrayList;
import java.util.List;

public class TrelloCardRepository {
    private static TrelloCardRepository repository;
    private final List<TrelloCard> cards;
    private List<Integer> queueNumbers = new ArrayList<>();

    private TrelloCardRepository() {
        TrelloUserDefinition userDefinition = TrelloUserDefinition.getInstance();
        TrelloUser user = TrelloUserRepository.getInstance().query(userDefinition);
        LoginView.directNav().login(user);
        BoardView board = BoardView.directNav();
        cards = board.getCards();
        BoardView.directNav().logout();
    }

    public static TrelloCardRepository getInstance() {
        if (repository == null) {
            repository = new TrelloCardRepository();
        }
        return repository;
    }

    public TrelloCard query(TrelloCardValidatable card) {
        if (card == null || card.getId() == null) {
            return queryForAvailableCard(card);
        } else {
            return getLatestIdentifiedCard(card);
        }
    }

    private TrelloCard getLatestIdentifiedCard(TrelloCardValidatable card) {
        UiRegion.suppressConstructionLogging(true);
        TrelloCard existingCard = null;
        if (card.getId() != null) {
            existingCard = CardView.directNav(card).toData();
        }
        UiRegion.suppressConstructionLogging(false);
        return existingCard;
    }

    private TrelloCard queryForAvailableCard(TrelloCardValidatable card) {
        UiRegion.suppressConstructionLogging(true);
        Integer queueNumber = takeANumber();
        waitYourTurn(queueNumber);
        for (TrelloCard candidate : cards) {
            if (candidate.equivalent(card)) {
                cards.remove(candidate);
                discardNumber(queueNumber);
                UiRegion.suppressConstructionLogging(false);
                return candidate;
            }
        }
        UiRegion.suppressConstructionLogging(false);
        discardNumber(queueNumber);
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
        TrelloUserDefinition userDefinition = TrelloUserDefinition.getInstance();
        UiRegion.suppressConstructionLogging(true);
        TrelloUser user = TrelloUserRepository.getInstance().query(userDefinition);
        LoginView.directNav().login(user);
        TrelloCard identifiedCard = BoardView.directNav().inList(card.getList()).addCard(card).inList(card.getList())
                .clickCard(card).toData();
        BoardView.directNav().logout();
        UiRegion.suppressConstructionLogging(false);
        return identifiedCard;
    }
}
