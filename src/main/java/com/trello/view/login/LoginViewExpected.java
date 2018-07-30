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
    public String getLoginButtonLabel() {
        return getCopy().getLoginButtonLabel();
    }

    @Override
    public String getSsoLoginText() {
        return getCopy().getSsoLoginText();
    }

}
