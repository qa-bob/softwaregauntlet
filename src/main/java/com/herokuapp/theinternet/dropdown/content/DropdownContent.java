package com.herokuapp.theinternet.dropdown.content;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class DropdownContent extends UiRegion implements DropdownContentValidatable {
    private static final String DESCRIPTION = "Dropdown Content";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.ID;
    private static final String LOCATOR_VALUE = "content";

    private DropdownContent(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static DropdownContent getInstance(UiElement parent) {
        return new DropdownContent(parent);
    }

    @Override
    public String getSelectedOption() {
        return UiElement.getInstance("Select-box", UiElement.LocatorType.ID, "dropdown", this.getElement()).getText();
    }

    @Override
    public String getHeading() {
        return UiElement.getInstance("Heading", UiElement.LocatorType.TAG, "h3", this.getElement()).getText();
    }
}
