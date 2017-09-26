package com.herokuapp.theinternet.region.footer;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class TheInternetFooter extends UiRegion implements TheInternetFooterValidatable {

    private TheInternetFooter(UiElement parent) {
        super(UiElement.getInstance("Footer", UiElement.LocatorType.ID, "page-footer", parent));
    }

    public static TheInternetFooter getInstance(UiElement parent) {
        return new TheInternetFooter(parent);
    }

    @Override
    public String getMessage() {
        return this.getElement().getText();
    }

    @Override
    public String getLinkText() {
        return getLinkElement().getText();
    }

    private UiElement getLinkElement() {
        return UiElement.getInstance("Link", UiElement.LocatorType.TAG, "a", this.getElement());
    }

    @Override
    public String getLinkHref() {
        return getLinkElement().getHref();
    }
}
