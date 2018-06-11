package com.trello.view.card;

import com.softwareonpurpose.gauntlet.environment.Environment;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardValidatable;
import com.trello.view.card.move.CardMoveModal;

public class CardView extends UiView implements CardViewValidatable {
    private static final String DESCRIPTION = "'Card' view";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.CLASS;
    private static final String LOCATOR_VALUE = "window";
    private static String DOMAIN_URL = Environment.getInstance().getTrelloDomain();
    private static final String VIEW_URI = String.format("%s/c", DOMAIN_URL);
    private String cardId;
    private String cardNumber;

    public CardView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static CardView directNav(TrelloCardValidatable card) {
        String cardId = card.getId();
        String cardNumber = card.getNumber();
        String cardTitle = card.getTitle().toLowerCase().replace(" ", "-");
        String relativeCardUri = String.format("%s/%s-%s", cardId, cardNumber, cardTitle);
        UiView.construct(CardView.class).load(relativeCardUri);
        return UiView.expect(CardView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().contains(VIEW_URI);
        confirmed &= getMoveElement().isDisplayed();
        return confirmed;
    }

    public CardMoveModal clickMove() {
        getMoveElement().click();
        return UiView.expect(CardMoveModal.class);
    }

    private UiElement getMoveElement() {
        return UiElement.getInstance("'Move' action", UiElement.LocatorType.CLASS, "js-move-card", this.getElement());
    }

    @Override
    public String getShowDetailsHref() {
        return getShowDetailsLinkElement().getHref();
    }

    private UiElement getShowDetailsLinkElement() {
        return UiElement.getInstance("Show details", UiElement.LocatorType.CLASS, "js-show-details", this.getElement());
    }

    @Override
    public String getShowDetailsLink() {
        return getShowDetailsLinkElement().getText();
    }

    private UiElement getAddCommentButtonElement() {
        String description = "'Add comment' button";
        return UiElement.getInstance(description, UiElement.LocatorType.CLASS, "js-add-comment", this.getElement());
    }

    @Override
    public String addCommentButtonLabel() {
        return getAddCommentButtonElement().getText();
    }

    @Override
    public String getMemberInitials() {
        return getMemberInitialsElement().getText();
    }

    private UiElement getMemberInitialsElement() {
        String description = "Member initials";
        return UiElement.getInstance(description, UiElement.LocatorType.CLASS, "member-initials", this.getElement());
    }

    @Override
    public String getEditDescriptionHref() {
        return getEditDescriptionLinkElement().getHref();
    }

    private UiElement getEditDescriptionLinkElement() {
        String description = "Edit description";
        return UiElement.getInstance(description, UiElement.LocatorType.CLASS, "js-edit-desc", this.getElement());
    }

    @Override
    public String getList() {
        return getListElement().getText();
    }

    private UiElement getListElement() {
        String locatorValue = "js-open-move-from-header";
        return UiElement.getInstance("List", UiElement.LocatorType.CLASS, locatorValue, getCurrentListElement());
    }

    private UiElement getCurrentListElement() {
        return UiElement.getInstance("Current list", UiElement.LocatorType.CLASS, "js-current-list", this.getElement());
    }

    @Override
    public String getListMessage() {
        return getCurrentListElement().getText();
    }

    @Override
    public String getAddCommentLabel() {
        return getAddCommentLabelElement().getText();
    }

    private UiElement getAddCommentLabelElement() {
        String description = "'Add comment' label";
        return UiElement.getInstance(description, UiElement.LocatorType.TAG, "h3", getAddCommentSectionElement());
    }

    private UiElement getAddCommentSectionElement() {
        String description = "'Add comment' section";
        String locatorValue = "add-comment-section";
        return UiElement.getInstance(description, UiElement.LocatorType.CLASS, locatorValue, this.getElement());
    }

    @Override
    public Boolean isAddCommentIconDisplayed() {
        return getAddCommentIconElement().isDisplayed();
    }

    private UiElement getAddCommentIconElement() {
        String description = "'Add comment' icon";
        return UiElement.getInstance(description, UiElement.LocatorType.CLASS, "icon-comment", this.getElement());
    }

    @Override
    public String getId() {
        if (cardId == null) {
            String uri = UiHost.getInstance().getUri();
            int idIndexStart = VIEW_URI.length() + 1;
            int idIndexEnd = uri.indexOf("/", idIndexStart);
            cardId = uri.substring(idIndexStart, idIndexEnd);
        }
        return cardId;
    }

    @Override
    public String getNumber() {
        if (cardNumber == null) {
            String uri = UiHost.getInstance().getUri();
            int idIndexStart = String.format("%s/%s", VIEW_URI, getId()).length() + 1;
            int idIndexEnd = uri.indexOf("-", idIndexStart);
            cardNumber = uri.substring(idIndexStart, idIndexEnd);
        }
        return cardNumber;
    }

    @Override
    public String getTitle() {
        return getTitleElement().getAttribute("value");
    }

    private UiElement getTitleElement() {
        return UiElement.getInstance("Title", UiElement.LocatorType.CLASS, "mod-card-back-title", this.getElement());
    }

    public TrelloCard toData() {
        String id = getId();
        String number = getNumber();
        String title = getTitle();
        CardMoveModal moveModal = clickMove();
        String board = moveModal.getBoard();
        String list = moveModal.getList();
        String position = moveModal.getPosition();
        return TrelloCard.getInstance(id, number, title, board, list, position);
    }
}
