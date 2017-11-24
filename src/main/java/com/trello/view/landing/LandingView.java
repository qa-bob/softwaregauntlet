package com.trello.view.landing;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.view.landing.content.LandingContent;
import com.trello.view.landing.content.LandingContentValidatable;
import com.trello.view.region.footer.Footer;
import com.trello.view.region.footer.FooterValidatable;
import com.trello.view.region.header.TrelloHeader;

public class LandingView extends UiView implements LandingViewValidatable {
    private static final String DESCRIPTION = "'Landing' view";
    private static final String VIEW_URI = "https://trello.com/";
    private static final String LOCATOR_VALUE = "body";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.TAG;

    public LandingView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().equals(VIEW_URI);
        confirmed &= UiElement.getInstance("Member boards view", UiElement.LocatorType.CLASS, "js-boards-page", this.getElement()).isDisplayed();
        return confirmed;
    }

    @Override
    public Footer inFooter() {
        return Footer.getInstance(this.getElement());
    }

    @Override
    public LandingContent inContent() {
        return LandingContent.getInstance(this.getElement());
    }

    @Override
    public TrelloHeader inHeader() {
        return TrelloHeader.getInstance(this.getElement());
    }
}
