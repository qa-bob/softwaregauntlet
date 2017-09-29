package com.herokuapp.theinternet.checkboxes.content;

import com.herokuapp.theinternet.checkboxes.CheckboxesContentValidatable;
import com.herokuapp.theinternet.checkboxes.CheckboxesView;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class CheckboxesContent extends UiRegion implements CheckboxesContentValidatable {
    private static final String DESCRIPTION = "'Checkboxes' content";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.ID;
    private static final String LOCATOR_VALUE = "content";

    private CheckboxesContent(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static CheckboxesContent getInstance(UiElement parent) {
        return new CheckboxesContent(parent);
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

    @Override
    public Boolean isCheckbox2Selected() {
        return isCheckboxSelected(2);
    }

    @Override
    public String getCheckbox1Label() {
        return getFormText()[0];
    }

    private String[] getFormText() {
        return getFormElement().getText().split("\n");
    }

    @Override
    public String getCheckbox2Label() {
        return getFormText()[1];
    }

    public CheckboxesView selectCheckbox(int ordinal, int numberOfSelections) {
        CheckboxesView view;
        for (int current = 1; current <= numberOfSelections; current += 1) {
            view = CheckboxesView.expect(CheckboxesView.class);
            view.inContent().getCheckboxElement(ordinal).click();
        }
        return CheckboxesView.expect(CheckboxesView.class);
    }
}
