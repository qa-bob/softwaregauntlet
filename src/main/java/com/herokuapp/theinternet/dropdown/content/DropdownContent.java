package com.herokuapp.theinternet.dropdown.content;

import com.herokuapp.theinternet.dropdown.DropdownView;
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
        return getSelectElement().getText();
    }

    private UiElement getSelectElement() {
        return UiElement.getInstance("Select-box", UiElement.LocatorType.ID, "dropdown", this.getElement());
    }

    @Override
    public String getHeading() {
        return UiElement.getInstance("Heading", UiElement.LocatorType.TAG, "h3", this.getElement()).getText();
    }

    @Override
    public Boolean isDefaultOptionEnabled() {
        return !getDefaultOptionElement().getAttribute("disabled").equals("true");
    }

    private UiElement getDefaultOptionElement() {
        return UiElement.getInstance("Default Option", UiElement.LocatorType.TAG, "option", 1, getSelectElement());
    }

    private DropdownView clickSelect() {
        getSelectElement().click();
        return DropdownView.expect(DropdownView.class);
    }

    private DropdownView clickOption(String option) {
        getOptionElement(option).click();
        return DropdownView.expect(DropdownView.class);
    }

    private UiElement getOptionElement(String option) {
        return UiElement.getInstance(String.format("'%s' option", option), UiElement.LocatorType.TAG, "option", "value", option, getSelectElement());
    }

    public DropdownView select(String option) {
        UiRegion.suppressConstructionLogging(true);
        DropdownView dropdownView = clickSelect().inContent().clickOption(option);
        UiRegion.suppressConstructionLogging(false);
        return dropdownView;
    }
}
