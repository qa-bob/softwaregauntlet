package com.trello.view.landing;

import com.trello.view.landing.content.LandingContentExpected;
import com.trello.view.region.footer.FooterExpected;
import com.trello.view.region.header.TrelloHeaderExpected;

public class LandingViewExpected implements LandingViewValidatable {
    public static LandingViewExpected getInstance() {
        return new LandingViewExpected();
    }

    @Override
    public FooterExpected inFooter() {
        return FooterExpected.getInstance();
    }

    @Override
    public LandingContentExpected inContent() {
        return LandingContentExpected.getInstance();
    }

    @Override
    public TrelloHeaderExpected inHeader() {
        return TrelloHeaderExpected.getInstance();
    }
}
