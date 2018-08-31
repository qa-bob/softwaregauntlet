package com.trello.data.card;

import com.softwareonpurpose.uinavigator.UiHost;
import com.trello.data.user.TrelloUser;
import com.trello.data.user.TrelloUserDefinition;
import com.trello.data.user.TrelloUserRepository;
import com.trello.view.board.BoardView;
import com.trello.view.card.CardView;
import com.trello.view.login.LoginView;

import java.util.List;

public class TrelloCardRepository {
    private static TrelloCardRepository repository;
    private static boolean acquiringInstance = false;
    private final List<TrelloCard> cards;

    private TrelloCardRepository() {
        TrelloUserDefinition userDefinition = TrelloUserDefinition.getInstance();
        TrelloUser user = TrelloUserRepository.getInstance().query(userDefinition);
        LoginView.directNav().login(user);
        BoardView board = BoardView.directNav();
        cards = board.getCards();
        BoardView.directNav().logout();
        UiHost.quitInstance();
    }

    public static TrelloCardRepository getInstance() {
        if (repository == null && !acquiringInstance) {
            acquiringInstance = true;
            repository = new TrelloCardRepository();
            acquiringInstance = false;
        }
        //noinspection WhileLoopSpinsOnField,StatementWithEmptyBody
        while(acquiringInstance);
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
        TrelloCard existingCard = null;
        if (card.getId() != null) {
            existingCard = CardView.directNav(card).toData();
        }
        return existingCard;
    }

    private TrelloCard queryForAvailableCard(TrelloCardValidatable card) {
        return identifyEquivalentCard(card);
    }

    private TrelloCard identifyEquivalentCard(TrelloCardValidatable card) {
        for (TrelloCard candidate : cards) {
            if (candidate.equivalent(card)) {
                cards.remove(candidate);
                return candidate;
            }
        }
        return null;
    }

    public TrelloCard add(TrelloCardDefinition card) {
        TrelloUser anyUser = TrelloUserRepository.getInstance().query();
        LoginView.directNav().login(anyUser);
        TrelloCard identifiedCard = addCard(card);
        BoardView.directNav().logout();
        return identifiedCard;
    }

    private TrelloCard addCard(TrelloCardDefinition card) {
        return BoardView.directNav().inList(card.getList()).addCard(card).inList(card.getList()).clickCard(card)
                .toData();
    }
}
