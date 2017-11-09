package com.herokuapp.theinternet.dynamiccontrols.content;

public interface DynamicControlsContentValidatable {
    String getHeading();

    String getContentDescription();

    Boolean isButtonDisplayed();

    String getButtonLabel();

    Boolean isCheckboxDisplayed();

    String getCheckboxLabel();

    Boolean isCheckboxSelected();

    Boolean isLoadingMessageDisplayed();

    String getLoadingMessage();
}
