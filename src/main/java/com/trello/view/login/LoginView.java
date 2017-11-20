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
        confirmed &= UiElement.getInstance("'Login' button", UiElement.LocatorType.CLASS, "global-header-section-button", this.getElement()).isDisplayed();
        return confirmed;
    }

    public void login(TrelloUser user) {
        getUsernameElement().set(user.getUsername());
        getPasswordElement().set(user.getPassword());
        getLoginButtonElement().click();
        UiView.expect(LandingView.class);
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
}
