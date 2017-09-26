package com.herokuapp.theinternet.region.header;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class TheInternetHeader extends UiRegion implements TheInternetHeaderValidatable {
    private static final String DESCRIPTION = "Header";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.TAG;
    private static final String LOCATOR_VALUE = "a";

    private TheInternetHeader(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static TheInternetHeader getInstance(UiElement parent) {
        return new TheInternetHeader(parent);
    }

    @Override
    public String getImageSource() {
        return getImageElement().getAttribute("src");
    }

    private UiElement getImageElement() {
        return UiElement.getInstance("Image", UiElement.LocatorType.TAG, "img", this.getElement()).setTipAttribute("alt");
    }

    @Override
    public String getAlternateText() {
        return getImageElement().getTip();
    }
}
