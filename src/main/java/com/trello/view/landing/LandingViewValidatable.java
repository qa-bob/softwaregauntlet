package com.trello.view.landing;

import com.trello.view.landing.content.LandingContentValidatable;
import com.trello.view.region.footer.FooterValidatable;
import com.trello.view.region.header.TrelloHeaderValidatable;

public interface LandingViewValidatable {
    FooterValidatable inFooter();

    LandingContentValidatable inContent();

    TrelloHeaderValidatable inHeader();
}
