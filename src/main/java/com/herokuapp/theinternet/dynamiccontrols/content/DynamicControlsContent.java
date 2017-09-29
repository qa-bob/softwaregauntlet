package com.herokuapp.theinternet.dynamiccontrols.content;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class DynamicControlsContent extends UiRegion implements DynamicControlsContentValidatable {
    private static final String DESCRIPTION = "'Dynamic Controls' content";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.ID;
    private static final String LOCATOR_VALUE = "content";
    private Boolean isCheckboxDisplayed;

    private DynamicControlsContent(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static DynamicControlsContent getInstance(UiElement parent) {
        return new DynamicControlsContent(parent);
    }

    @Override
    public String getHeading() {
        return UiElement.getInstance("Heading", UiElement.LocatorType.TAG, "h4", this.getElement()).getText();
    }

    @Override
    public String getContentDescription() {
        return UiElement.getInstance("Description", UiElement.LocatorType.TAG, "p", this.getElement()).getText();
    }

    @Override
    public Boolean isButtonDisplayed() {
        return getButtonElement().isDisplayed();
    }

    private UiElement getButtonElement() {
        return UiElement.getInstance("Button", UiElement.LocatorType.ID, "btn", this.getElement());
    }

    @Override
    public String getButtonLabel() {
        return getButtonElement().getText();
    }

    @Override
    public Boolean isCheckboxDisplayed() {
        if (isCheckboxDisplayed == null) {
            isCheckboxDisplayed = getCheckboxControlElement().isDisplayed();
        }
        return isCheckboxDisplayed;
    }

    private UiElement getCheckboxControlElement() {
        return UiElement.getInstance("'Checkbox' control", UiElement.LocatorType.ID, "checkbox", this.getElement());
    }

    @Override
    public String getCheckboxLabel() {
        return isCheckboxDisplayed() ? getCheckboxControlElement().getText() : null;
    }

    @Override
    public Boolean isCheckboxSelected() {
        return isCheckboxDisplayed() && getCheckboxElement().isSelected();
    }

    private UiElement getCheckboxElement() {
        return UiElement.getInstance("Checkbox", UiElement.LocatorType.TAG, "input", this.getElement());
    }
}
