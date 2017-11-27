package com.trello.view.board;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.data.card.TrelloCard;
import com.trello.view.board.list.CardList;
import com.trello.view.board.list.card.CardRegion;
import com.trello.view.card.CardView;

import java.util.ArrayList;
import java.util.List;

public class BoardView extends UiView implements BoardViewValidatable {
    private static final String VIEW_URI = "https://trello.com/b/mFnfsTwp/application-project";
    private static final String DESCRIPTION = "'Board' view";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.CLASS;
    private static final String LOCATOR_VALUE = "body-board-view";

    @SuppressWarnings("WeakerAccess")
    public BoardView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static BoardView directNav() {
        new BoardView().load();
        return UiView.expect(BoardView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().contains(VIEW_URI);
        confirmed &= this.getElement().isDisplayed();
        confirmed &= getAvatarElement().isDisplayed();
        return confirmed;
    }

    @Override
    public CardList inList(String name) {
        List<UiElement> listElements = UiElement.getList("'List' region", UiElement.LocatorType.CLASS,
                "list-wrapper", this.getElement());
        int listCount = listElements.size();
        for (int listOrdinal = 1; listOrdinal <= listCount; listOrdinal++) {
            CardList candidate = CardList.getInstance(listOrdinal, this.getElement());
            if (candidate.getName().equals(name)) {
                return candidate;
            }
        }
        return null;
    }

    public void logout() {
        getAvatarElement().click();
        BoardView view = UiView.expect(BoardView.class);
        view.clickLogout();
    }

    private UiElement getAvatarElement() {
        return UiElement.getInstance("Avatar", UiElement.LocatorType.CLASS, "header-avatar", this.getElement());
    }

    private void clickLogout() {
        UiElement.getInstance("'Logout' link", UiElement.LocatorType.CLASS, "js-logout", this.getElement()).click();
    }

    public List<TrelloCard> getCards() {
        List<TrelloCard> cards = new ArrayList<>();
        List<TrelloCard> regionCards = new ArrayList<>();
        List<UiElement> elements = UiElement.getList("Card", UiElement.LocatorType.CLASS, "list-card", this
                .getElement());
        int ordinal = 0;
        //noinspection unused
        for (UiElement element : elements) {
            ordinal++;
            regionCards.add(CardRegion.getInstance(ordinal, this.getElement()).toData());
        }
        for (TrelloCard regionCard : regionCards) {
            cards.add(CardView.directNav(regionCard).toData());
        }
        BoardView.directNav().logout();
        return cards;
    }
}
