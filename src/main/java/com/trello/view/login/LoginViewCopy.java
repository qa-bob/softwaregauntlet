package com.trello.view.login;

import com.trello.copy.TrelloCopy;

public class LoginViewCopy {
    private TrelloCopy source;

    public static LoginViewCopy getInstance() {
        return new LoginViewCopy();
    }

    public String getTitle() {
        return String.format("%s %s %s", getSource().getLogIn(), getSource().getTo(), getSource().getAppName());
    }

    private TrelloCopy getSource() {
        if (source == null) {
            source = TrelloCopy.getInstance();
        }
        return source;
    }

    String getUsernameLabel() {
        return getSource().getEmailUsername();
    }

    String getPasswordLabel() {
        return getSource().getPassword();
    }

    String getPasswordPlaceholder() {
        return String.format("%s %s", getSource().getForExample(), getSource().getPasswordExample());
    }

    String getLoginButtonLabel() {
        return getSource().getLogInCapitalized();
    }

    String getForgotPasswordMessage() {
        return String.format("%s? %s.", getSource().getForgotPassword(), getSource().getReset());
    }

    String getResetLinkText() {
        return String.format("%s.", getSource().getReset());
    }

    String getSsoLoginText() {
        return String.format("%s %s", getSource().getLogIn(), getSource().withSso());
    }

    String getCreateAccountLinkText() {
        return String.format("%s %s %s.", getSource().getCreate(), getSource().getAppName(), getSource().getAccount());
    }
}
