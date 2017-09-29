package com.herokuapp.theinternet.dynamiccontrols.content;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class DynamicControlsContent extends UiRegion implements DynamicControlsContentValidatable {
    private static final String DESCRIPTION = "'Dynamic Controls' content";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.ID;
    private static final String LOCATOR_VALUE = "content";

    protected DynamicControlsContent(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static DynamicControlsContent getInstance(UiElement parent) {
        return new DynamicControlsContent(parent);
    }
}
