package com.trello.view.card;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.data.card.TrelloCard;
import com.trello.data.card.TrelloCardValidatable;
import com.trello.view.card.move.CardMoveModal;

public class CardView extends UiView implements CardViewValidatable {
    private static final String DESCRIPTION = "'Card' view";
    private static final String VIEW_URI = "https://trello.com/c";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.CLASS;
    private static final String LOCATOR_VALUE = "window";
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
        UiView.instantiateView(CardView.class).load(relativeCardUri);
        return UiView.expect(CardView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().equals("https://trello.com/c/aMBOItYP/1-tek-user-story");
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
        return UiElement.getInstance("'Add comment' button", UiElement.LocatorType.CLASS, "js-add-comment", this
                .getElement());
    }

    @Override
    public String addCommentButtonLabel() {
        return getAddCommentButtonElement().getText();
    }

    @Override
    public String getMemberInitials() {
        return UiElement.getInstance("Member initials", UiElement.LocatorType.CLASS, "member-initials", this
                .getElement()).getText();
    }

    @Override
    public String getEditDescriptionHref() {
        return getEditDescriptionLinkElement().getHref();
    }

    private UiElement getEditDescriptionLinkElement() {
        return UiElement.getInstance("Edit description", UiElement.LocatorType.CLASS, "js-edit-desc", this.getElement
                ());
    }

    @Override
    public String getList() {
        return UiElement.getInstance("List", UiElement.LocatorType.CLASS, "js-open-move-from-header",
                getCurrentListElement()).getText();
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
        return UiElement.getInstance("'Add comment' label", UiElement.LocatorType.TAG, "h3",
                getAddCommentSectionElement()).getText();
    }

    private UiElement getAddCommentSectionElement() {
        return UiElement.getInstance("'Add comment' section", UiElement.LocatorType.CLASS, "add-comment-section",
                this.getElement());
    }

    @Override
    public Boolean isAddCommentIconDisplayed() {
        return UiElement.getInstance("'Add comment' icon", UiElement.LocatorType.CLASS, "icon-comment", this
                .getElement()).isDisplayed();
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
            String baseUri = String.format("%s/%s", VIEW_URI, getId());
            String uri = UiHost.getInstance().getUri();
            int idIndexStart = baseUri.length() + 1;
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
