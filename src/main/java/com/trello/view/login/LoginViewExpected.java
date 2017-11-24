package com.trello.view.login;

public class LoginViewExpected implements LoginViewValidatable {
    private LoginViewCopy copy;

    public static LoginViewExpected getInstance() {
        return new LoginViewExpected();
    }

    @Override
    public String getTitle() {
        return getCopy().getTitle();
    }

    private LoginViewCopy getCopy() {
        if (copy == null) {
            copy = LoginViewCopy.getInstance();
        }
        return copy;
    }

    @Override
    public String getUsernameLabel() {
        return getCopy().getUsernameLabel();
    }

    @Override
    public String getPasswordLabel() {
        return getCopy().getPasswordLabel();
    }

    @Override
    public String getPasswordPlaceholder() {
        return getCopy().getPasswordPlaceholder();
    }

    @Override
    public String getLoginButtonLabel() {
        return getCopy().getLoginButtonLabel();
    }

    @Override
    public String getForgotPasswordMessage() {
        return getCopy().getForgotPasswordMessage();
    }

    @Override
    public String getResetLinkText() {
        return getCopy().getResetLinkText();
    }

    @Override
    public String getSsoLoginText() {
        return getCopy().getSsoLoginText();
    }

    @Override
    public String getCreateAccountLinkText() {
        return getCopy().getCreateAccountLinkText();
    }
}
