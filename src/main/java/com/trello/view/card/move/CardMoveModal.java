package com.trello.view.card.move;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.view.card.CardView;

public class CardMoveModal extends UiView implements CardMoveModalValidatable {
    private static final String LOCATOR_VALUE = "pop-over";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.CLASS;
    private static final String DESCRIPTION = "'Move Card' modal";
    private static final String VIEW_URI = "https://trello.com/c/aMBOItYP/1-tek-user-story";

    protected CardMoveModal() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    static CardMoveModal directNav() {
        return CardView.directNav().clickMove();
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().equals("https://trello.com/c/aMBOItYP/1-tek-user-story");
        confirmed &= "Move Card".equals(getTitle());
        return confirmed;
    }

    @Override
    public String getTitle() {
        return UiElement.getInstance("Title", UiElement.LocatorType.CLASS, "pop-over-header-title").getText();
    }

    void move(String list) {
        //  'Done' list ID = "5a12fe5ee8d49dd598dea9c6"
        UiElement.getInstance("'List' select", UiElement.LocatorType.CLASS, "js-select-list", this.getElement()).set(list);
        UiView.expect(CardMoveModal.class);
    }
}
