package com.herokuapp.theinternet.dynamiccontrols.content;

public class DynamicControlsContentExpected implements DynamicControlsContentValidatable {
    public static DynamicControlsContentExpected getInstance() {
        return new DynamicControlsContentExpected();
    }

    @Override
    public String getHeading() {
        return "Dynamic Controls";
    }

    @Override
    public String getContentDescription() {
        return "This example demonstrates when controls (e.g., checkbox, option button, etc.) are added or removed asynchronously.";
    }

    @Override
    public Boolean isButtonDisplayed() {
        return true;
    }

    @Override
    public String getButtonLabel() {
        return "Remove";
    }

    @Override
    public Boolean isCheckboxDisplayed() {
        return true;
    }

    @Override
    public String getCheckboxLabel() {
        return "A checkbox";
    }

    @Override
    public Boolean isCheckboxSelected() {
        return false;
    }
}
