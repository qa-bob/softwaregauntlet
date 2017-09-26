package com.herokuapp.theinternet.checkboxes;

import com.herokuapp.theinternet.region.footer.TheInternetFooter;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;

public class CheckboxView extends UiView implements CheckboxViewValidatable {
    private static final String DESCRIPTION = "'Checkboxes' view";
    private static final String VIEW_URI = "http://the-internet.herokuapp.com/checkboxes";

    /**
     * @deprecated Exclusively for use by UiNavigator; NOT to be called explicitly
     */
    @SuppressWarnings("DeprecatedIsStillUsed")
    public CheckboxView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, UiElement.LocatorType.TAG, "body"));
    }

    static CheckboxView directNav() {
        instantiateView(CheckboxView.class).load();
        return expect(CheckboxView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().contains(VIEW_URI);
        confirmed &= this.getElement().waitUntilVisible();
        return confirmed;
    }

    @Override
    public String getTitle() {
        return getTitleElement().getText();
    }

    private UiElement getTitleElement() {
        return UiElement.getInstance("Title", UiElement.LocatorType.TAG, "h3", this.getElement());
    }

    @Override
    public Boolean isCheckbox1Selected() {
        return isCheckboxSelected(1);
    }

    @Override
    public Boolean isCheckbox2Selected() {
        return isCheckboxSelected(2);
    }

    @Override
    public String getCheckbox1Label() {
        return getFormText()[0];
    }

    @Override
    public String getCheckbox2Label() {
        return getFormText()[1];
    }

    @Override
    public TheInternetFooter inFooter() {
        return TheInternetFooter.getInstance(this.getElement());
    }

    private String[] getFormText() {
        return getFormElement().getText().split("\n");
    }

    private Boolean isCheckboxSelected(int ordinal) {
        String tip = getCheckboxElement(ordinal).getAttribute("checked");
        return tip != null && tip.equals("true");
    }

    private UiElement getCheckboxElement(int ordinal) {
        String description = String.format("Checkbox %d", ordinal);
        return UiElement.getInstance(description, UiElement.LocatorType.TAG, "input", ordinal, getFormElement());
    }

    private UiElement getFormElement() {
        return UiElement.getInstance("Checkbox Form", UiElement.LocatorType.ID, "checkboxes", this.getElement());
    }

    CheckboxView selectCheckbox(int ordinal, int numberOfSelections) {
        CheckboxView view;
        for (int current = 1; current <= numberOfSelections; current += 1) {
            view = expect(CheckboxView.class);
            view.getCheckboxElement(ordinal).click();
        }
        return expect(CheckboxView.class);
    }
}
