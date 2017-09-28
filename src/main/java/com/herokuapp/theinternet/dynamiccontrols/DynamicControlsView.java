package com.herokuapp.theinternet.dynamiccontrols;

import com.herokuapp.theinternet.region.footer.TheInternetFooter;
import com.herokuapp.theinternet.region.header.TheInternetHeader;
import com.softwareonpurpose.gauntlet.environment.Environment;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;

public class DynamicControlsView extends UiView implements DynamicControlsViewValidatable {
    private static final String VIEW_URI = String.format("%s/%s", Environment.getInstance().getDomainUri(), "dynamic_controls");
    private static final String DESCRIPTION = "'Dynamic Controls' view";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.TAG;
    private static final String LOCATOR_VALUE = "body";

    /**
     * @deprecated Exclusively for use by UiNavigator; NOT to be called explicitly
     */
    @SuppressWarnings("DeprecatedIsStillUsed")
    public DynamicControlsView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    static DynamicControlsView directNav() {
        instantiateView(DynamicControlsView.class).load();
        return expect(DynamicControlsView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        Boolean confirmed = UiHost.getInstance().getUri().contains(VIEW_URI);
        confirmed &= this.getElement().waitUntilVisible();
        return confirmed;
    }

    @Override
    public TheInternetHeader inHeader() {
        return TheInternetHeader.getInstance(this.getElement());
    }

    @Override
    public TheInternetFooter inFooter() {
        return TheInternetFooter.getInstance(this.getElement());
    }
}
