package com.trello.view.card.copy;

import com.softwareonpurpose.gauntlet.environment.Environment;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiView;

public class CardCopyModal extends UiView implements CardCopyModalValidatable {
    private static final String DOMAIN_URL = Environment.getInstance().getTrelloDomain();
    private static final String VIEW_URI = String.format("%s/c", DOMAIN_URL);
    private static final String DESCRIPTION = "Copy Modal";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.CLASS;
    private static final String LOCATOR_VALUE = "pop-over";

    /***
     * @deprecated Replace use of this constructor with getInstance() creation method
     */
    public CardCopyModal() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = this.getElement().waitUntilVisible();
        return confirmed;
    }
}
