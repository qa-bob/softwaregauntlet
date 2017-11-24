package com.trello.view.login;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;
import com.trello.data.user.TrelloUser;
import com.trello.view.landing.LandingView;

public class LoginView extends UiView implements LoginViewValidatable {
    private static final String DESCRIPTION = "'Login' view";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.TAG;
    private static final String LOCATOR_VALUE = "body";
    private static final String VIEW_URI = "https://trello.com/login";

    @SuppressWarnings("WeakerAccess")
    public LoginView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static LoginView directNav() {
        new LoginView().load();
        return UiView.expect(LoginView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().equals(VIEW_URI);
        confirmed &= "Landing-Marquee".equals(this.getElement().getAttribute("data-track-group"));
        confirmed &= getLoginButtonElement().isDisplayed();
        return confirmed;
    }

    public LandingView login(TrelloUser user) {
        getUsernameElement().set(user.getUsername());
        getPasswordElement().set(user.getPassword());
        getLoginButtonElement().click();
        return UiView.expect(LandingView.class);
    }

    private UiElement getUsernameElement() {
        return UiElement.getInstance("Username", UiElement.LocatorType.NAME, "user", this.getElement());
    }

    private UiElement getPasswordElement() {
        return UiElement.getInstance("Password", UiElement.LocatorType.NAME, "password", this.getElement());
    }

    private UiElement getLoginButtonElement() {
        return UiElement.getInstance("'Login' button", UiElement.LocatorType.ID, "login", this.getElement());
    }

    @Override
    public String getTitle() {
        return UiElement.getInstance("Title", UiElement.LocatorType.TAG, "h1", this.getElement()).getText();
    }

    @Override
    public String getUsernameLabel() {
        String description = "'Username' label";
        return UiElement.getInstance(description, UiElement.LocatorType.TAG, "label", getUsernameContainer()).getText();
    }

    private UiElement getUsernameContainer() {
        String description = "'Username' container";
        return UiElement.getInstance(description, UiElement.LocatorType.ID, "login-form", this.getElement());
    }

    @Override
    public String getPasswordLabel() {
        String desc = "'Password' label";
        return UiElement.getInstance(desc, UiElement.LocatorType.TAG, "label", 2, getUsernameContainer()).getText();
    }

    @Override
    public String getPasswordPlaceholder() {
        String description = "'Password' placeholder";
        return UiElement.getInstance(description, UiElement.LocatorType.NAME, "password", this.getElement()).getTip();
    }

    @Override
    public String getLoginButtonLabel() {
        String desc = "'Login' button label";
        return UiElement.getInstance(desc, UiElement.LocatorType.ID, "login", this.getElement()).getAttribute("value");
    }

    @Override
    public String getForgotPasswordMessage() {
        UiElement element = getForgetPasswordMessageElement();
        return element.getText();
    }

    private UiElement getForgetPasswordMessageElement() {
        String desc = "'Forgot password' message";
        String locatorValue = "login-forget-password";
        return UiElement.getInstance(desc, UiElement.LocatorType.CLASS, locatorValue, this.getElement());
    }

    @Override
    public String getResetLinkText() {
        String desc = "'Reset' link text";
        return UiElement.getInstance(desc, UiElement.LocatorType.TAG, "a", getForgetPasswordMessageElement()).getText();
    }

    @Override
    public String getSsoLoginText() {
        String desc = "'Sso login' link text";
        UiElement parent = getLoginPasswordContainerElement();
        return UiElement.getInstance(desc, UiElement.LocatorType.TAG, "p", parent).getText();
    }

    private UiElement getLoginPasswordContainerElement() {
        String desc = "'Login password' container";
        return UiElement.getInstance(desc, UiElement.LocatorType.CLASS, "login-password-container", this.getElement());
    }

    @Override
    public String getCreateAccountLinkText() {
        String desc = "'Create account' link text";
        return UiElement.getInstance(desc, UiElement.LocatorType.ID, "signup", this.getElement()).getText();
    }
}
