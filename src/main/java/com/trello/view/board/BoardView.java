package com.trello.view.board;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.view.board.list.CardList;
import com.trello.view.card.CardView;

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

    public CardView clickCard(int ordinal) {
        UiElement.getInstance("Card", UiElement.LocatorType.CLASS, "list-card", ordinal, this.getElement()).click();
        return UiView.expect(CardView.class);
    }

    public int getCardCount() {
        return UiElement.getList("Card", UiElement.LocatorType.CLASS, "list-card", this.getElement()).size();
    }

    public void logout() {
        UiElement.getInstance("Avatar", UiElement.LocatorType.CLASS, "header-avatar", this.getElement()).click();
        BoardView view = UiView.expect(BoardView.class);
        view.clickLogout();
    }

    private void clickLogout() {
        UiElement.getInstance("'Logout' link", UiElement.LocatorType.CLASS, "js-logout", this.getElement()).click();
    }
}
