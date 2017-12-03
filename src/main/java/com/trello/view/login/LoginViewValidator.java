package com.trello.view.login;

import com.softwareonpurpose.validator4test.Validator;

public class LoginViewValidator extends Validator {
    private static final String DESCRIPTION = "'Login' view";
    private final LoginViewValidatable expected;
    private final LoginViewValidatable actual;

    private LoginViewValidator(LoginViewExpected expected, LoginView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static LoginViewValidator getInstance(LoginViewExpected expected, LoginView actual) {
        return new LoginViewValidator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        String createAccountDesc = "'Create a Trello account' link text";
        verify("Title", expected.getTitle(), actual.getTitle());
        verify("'Username' label", expected.getUsernameLabel(), actual.getUsernameLabel());
        verify("'Password' label", expected.getPasswordLabel(), actual.getPasswordLabel());
        verify("'Password' placeholder", expected.getPasswordPlaceholder(), expected.getPasswordPlaceholder());
        verify("'Login button' label", expected.getLoginButtonLabel(), actual.getLoginButtonLabel());
        verify("'Forgot password' message", expected.getForgotPasswordMessage(), actual.getForgotPasswordMessage());
        verify("'Reset' link text", expected.getResetLinkText(), actual.getResetLinkText());
        verify("'Log in with SSO' link text", expected.getSsoLoginText(), actual.getSsoLoginText());
        verify(createAccountDesc, expected.getCreateAccountLinkText(), actual.getCreateAccountLinkText());
    }
}