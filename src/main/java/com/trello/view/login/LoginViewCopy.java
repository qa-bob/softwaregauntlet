package com.trello.view.login;

public class LoginViewCopy {
    private static final String VIEW_TITLE = "Log in to Trello";
    private static final String USERNAME_LABEL = "Email (or username)";
    private static final String PASSWORD_LABEL = "Password";
    private static final String PASSWORD_PLACEHOLDER = "e.g., ••••••••••••";
    private static final String LOGIN_BUTTON_LABEL = "Log In";
    private static final String FORGOT_PASSWORD_MESSAGE = "Forgot your password? Reset it.";
    private static final String RESET_LINK_TEXT = "Reset it.";
    private static final String SSO_LOGIN_TEXT = "Log in with SSO";
    private static final String CREATE_ACCOUNT_LINK_TEXT = "Create a Trello account.";

    public static LoginViewCopy getInstance() {
        return new LoginViewCopy();
    }

    public String getTitle() {
        return VIEW_TITLE;
    }

    String getUsernameLabel() {
        return USERNAME_LABEL;
    }

    String getPasswordLabel() {
        return PASSWORD_LABEL;
    }

    String getPasswordPlaceholder() {
        return PASSWORD_PLACEHOLDER;
    }

    String getLoginButtonLabel() {
        return LOGIN_BUTTON_LABEL;
    }

    String getForgotPasswordMessage() {
        return FORGOT_PASSWORD_MESSAGE;
    }

    String getResetLinkText() {
        return RESET_LINK_TEXT;
    }

    String getSsoLoginText() {
        return SSO_LOGIN_TEXT;
    }

    String getCreateAccountLinkText() {
        return CREATE_ACCOUNT_LINK_TEXT;
    }
}
