package com.herokuapp.theinternet.checkboxes;

import com.herokuapp.theinternet.checkboxes.content.CheckboxesContent;
import com.herokuapp.theinternet.region.footer.TheInternetFooter;
import com.herokuapp.theinternet.region.header.TheInternetHeader;
import com.softwareonpurpose.gauntlet.environment.Environment;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;

public class CheckboxesView extends UiView implements CheckboxesViewValidatable {
    private static final String DESCRIPTION = "'Checkboxes' view";
    private static final String VIEW_URI = String.format("%s/%s", Environment.getInstance().getDomainUri(), "checkboxes");

    /**
     * @deprecated Exclusively for use by UiNavigator; NOT to be called explicitly
     */
    @SuppressWarnings("DeprecatedIsStillUsed")
    public CheckboxesView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, UiElement.LocatorType.TAG, "body"));
    }

    static CheckboxesView directNav() {
        instantiateView(CheckboxesView.class).load();
        return expect(CheckboxesView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().contains(VIEW_URI);
        confirmed &= this.getElement().waitUntilVisible();
        return confirmed;
    }

    @Override
    public TheInternetFooter inFooter() {
        return TheInternetFooter.getInstance(this.getElement());
    }

    @Override
    public TheInternetHeader inHeader() {
        return TheInternetHeader.getInstance(this.getElement());
    }

    @Override
    public CheckboxesContent inContent() {
        return CheckboxesContent.getInstance(this.getElement());
    }

    CheckboxesView select(int checkboxOrdinal, Integer numberOfClicks) {
        return inContent().selectCheckbox(checkboxOrdinal, numberOfClicks);
    }
}
