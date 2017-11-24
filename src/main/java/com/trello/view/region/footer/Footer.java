package com.trello.view.region.footer;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class Footer extends UiRegion implements FooterValidatable {
    private static final String DESCRIPTION = "'Footer' region";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.ID;
    private static final String LOCATOR_VALUE = "footer";

    private Footer(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static Footer getInstance(UiElement parent) {
        return new Footer(parent);
    }
}
