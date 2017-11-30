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
        return getTitleElement().getText();
    }

    private UiElement getTitleElement() {
        return UiElement.getInstance("Title", UiElement.LocatorType.TAG, "h1", this.getElement());
    }

    @Override
    public String getUsernameLabel() {
        return getUsernameLabelElement().getText();
    }

    private UiElement getUsernameLabelElement() {
        String description = "'Username' label";
        return UiElement.getInstance(description, UiElement.LocatorType.TAG, "label", getUsernameContainerElement());
    }

    private UiElement getUsernameContainerElement() {
        String description = "'Username' container";
        return UiElement.getInstance(description, UiElement.LocatorType.ID, "login-form", this.getElement());
    }

    @Override
    public String getPasswordLabel() {
        return getPasswordLabelElement().getText();
    }

    private UiElement getPasswordLabelElement() {
        return UiElement.getInstance("'Password' label", UiElement.LocatorType.TAG, "label", 2,
                getUsernameContainerElement());
    }

    @Override
    public String getPasswordPlaceholder() {
        return getPasswordElement().getTip();
    }

    @Override
    public String getLoginButtonLabel() {
        return getLoginButtonElement().getAttribute("value");
    }

    @Override
    public String getForgotPasswordMessage() {
        return getForgetPasswordMessageElement().getText();
    }

    private UiElement getForgetPasswordMessageElement() {
        String desc = "'Forgot password' message";
        String locatorValue = "login-forget-password";
        return UiElement.getInstance(desc, UiElement.LocatorType.CLASS, locatorValue, this.getElement());
    }

    @Override
    public String getResetLinkText() {
        return getResetLinkElement().getText();
    }

    private UiElement getResetLinkElement() {
        String description = "'Reset' link text";
        return UiElement.getInstance(description, UiElement.LocatorType.TAG, "a", getForgetPasswordMessageElement());
    }

    @Override
    public String getSsoLoginText() {
        return getSsoLoginElement().getText();
    }

    private UiElement getSsoLoginElement() {
        String description = "'Sso login' link text";
        return UiElement.getInstance(description, UiElement.LocatorType.TAG, "p", getLoginPasswordContainerElement());
    }

    private UiElement getLoginPasswordContainerElement() {
        String desc = "'Login password' container";
        return UiElement.getInstance(desc, UiElement.LocatorType.CLASS, "login-password-container", this.getElement());
    }

    @Override
    public String getCreateAccountLinkText() {
        return getAccountLinkElement().getText();
    }

    private UiElement getAccountLinkElement() {
        String description = "'Create account' link text";
        return UiElement.getInstance(description, UiElement.LocatorType.ID, "signup", this.getElement());
    }
}
