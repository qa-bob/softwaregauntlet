package com.trello.view.landing;

import com.softwareonpurpose.gauntlet.environment.Environment;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.view.landing.content.LandingContent;
import com.trello.view.region.header.TrelloHeader;

public class LandingView extends UiView implements LandingViewValidatable {
    private static final String DESCRIPTION = "'Landing' view";
    private static final String VIEW_URI = Environment.getInstance().getTrelloDomain();
    private static final String LOCATOR_VALUE = "body";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.TAG;

    public LandingView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static LandingView directNav() {
        UiView.instantiateView(LandingView.class).load();
        return UiView.expect(LandingView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().contains(VIEW_URI);
        confirmed &= getMemberBoardsElement().isDisplayed();
        return confirmed;
    }

    private UiElement getMemberBoardsElement() {
        return UiElement.getInstance("Member boards", UiElement.LocatorType.CLASS, "js-boards-page", this.getElement());
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
