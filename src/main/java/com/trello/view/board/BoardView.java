package com.trello.view.board;

import com.softwareonpurpose.gauntlet.environment.Environment;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.data.card.TrelloCard;
import com.trello.view.board.list.CardList;
import com.trello.view.board.list.card.CardRegion;
import com.trello.view.card.CardView;
import com.trello.view.region.header.TrelloHeader;

import java.util.ArrayList;
import java.util.List;

public class BoardView extends UiView implements BoardViewValidatable {
    private static final String DOMAIN_URL = Environment.getInstance().getTrelloDomain();
    @SuppressWarnings("SpellCheckingInspection")
    private static final String VIEW_URI = String.format("%s/b/mFnfsTwp/application-project", DOMAIN_URL);
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

    @Override
    public TrelloHeader inHeader() {
        return TrelloHeader.getInstance(this.getElement());
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
        return getCardDetails(getCardRegionData(getCardRegionElements()));
    }

    private List<UiElement> getCardRegionElements() {
        return UiElement.getList("Card", UiElement.LocatorType.CLASS, "list-card", this.getElement());
    }

    private List<TrelloCard> getCardRegionData(List<UiElement> elements) {
        List<TrelloCard> cardRegions = new ArrayList<>();
        int ordinal = 0;
        //noinspection unused
        for (UiElement element : elements) {
            ordinal++;
            cardRegions.add(CardRegion.getInstance(ordinal, this.getElement()).toData());
        }
        return cardRegions;
    }

    private List<TrelloCard> getCardDetails(List<TrelloCard> cardRegions) {
        List<TrelloCard> cards = new ArrayList<>();
        for (TrelloCard regionCard : cardRegions) {
            CardView cardView = CardView.directNav(regionCard);
            cards.add(cardView.toData());
        }
        return cards;
    }
}
