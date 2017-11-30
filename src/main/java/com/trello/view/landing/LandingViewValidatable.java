package com.trello.view.landing;

import com.trello.view.landing.content.LandingContentValidatable;
import com.trello.view.region.header.TrelloHeaderValidatable;

public interface LandingViewValidatable {

    LandingContentValidatable inContent();

    TrelloHeaderValidatable inHeader();
}
