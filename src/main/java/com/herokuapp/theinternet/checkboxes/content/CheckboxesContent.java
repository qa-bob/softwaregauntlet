package com.herokuapp.theinternet.checkboxes.content;

import com.herokuapp.theinternet.checkboxes.CheckboxesContentValidatable;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class CheckboxesContent extends UiRegion implements CheckboxesContentValidatable {
    private static final String DESCRIPTION = "'Checkboxes' content";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.ID;
    private static final String LOCATOR_VALUE = "content";

    protected CheckboxesContent(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static CheckboxesContent getInstance(UiElement parent) {
        return new CheckboxesContent(parent);
    }
}
