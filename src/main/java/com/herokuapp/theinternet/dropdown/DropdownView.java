package com.herokuapp.theinternet.dropdown;

import com.herokuapp.theinternet.dropdown.content.DropdownContent;
import com.herokuapp.theinternet.region.footer.TheInternetFooter;
import com.herokuapp.theinternet.region.header.TheInternetHeader;
import com.softwareonpurpose.gauntlet.environment.Environment;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;

public class DropdownView extends UiView implements DropdownViewValidatable {
    private static final String VIEW_URI = String.format("%s/%s", Environment.getInstance().getDomainUri(), "dropdown");
    private static final String DESCRIPTION = "'Dropdown' view";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.TAG;
    private static final String LOCATOR_VIEW = "body";

    public DropdownView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VIEW));
    }

    static DropdownView directNav() {
        instantiateView(DropdownView.class).load();
        return expect(DropdownView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().contains(VIEW_URI);
        confirmed &= this.getElement().waitUntilVisible();
        return confirmed;
    }

    @Override
    public TheInternetHeader inHeader() {
        return TheInternetHeader.getInstance(this.getElement());
    }

    @Override
    public DropdownContent inContent() {
        return DropdownContent.getInstance((this.getElement()));
    }

    @Override
    public TheInternetFooter inFooter() {
        return TheInternetFooter.getInstance(this.getElement());
    }
}
