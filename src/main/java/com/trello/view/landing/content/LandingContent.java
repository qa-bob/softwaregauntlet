package com.trello.view.landing.content;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class LandingContent extends UiRegion implements LandingContentValidatable {
    private static final String DESCRIPTION = "'Landing content' region";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.ID;
    private static final String LOCATOR_VALUE = "content";

    private LandingContent(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static LandingContent getInstance(UiElement parent) {
        return new LandingContent(parent);
    }
}
