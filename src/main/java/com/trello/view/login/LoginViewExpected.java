package com.trello.view.login;

public class LoginViewExpected implements LoginViewValidatable {
    public static LoginViewExpected getInstance() {
        return new LoginViewExpected();
    }

    @Override
    public String getTitle() {
        return "Log in to Trello";
    }

    @Override
    public String getUsernameLabel() {
        return "Email (or username)";
    }

    @Override
    public String getPasswordLabel() {
        return "Password";
    }

    @Override
    public String getPasswordPlaceholder() {
        return "e.g., ••••••••••••";
    }

    @Override
    public String getLoginButtonLabel() {
        return "Log In";
    }

    @Override
    public String getForgotPasswordMessage() {
        return "Forgot your password? Reset it.";
    }

    @Override
    public String getResetLinkText() {
        return "Reset it.";
    }

    @Override
    public String getSsoLoginText() {
        return "Log in with SSO";
    }

    @Override
    public String getCreateAccountLinkText() {
        return "Create a Trello account.";
    }
}
