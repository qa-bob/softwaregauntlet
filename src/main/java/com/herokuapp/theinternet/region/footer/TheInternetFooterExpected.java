package com.herokuapp.theinternet.region.footer;

public class TheInternetFooterExpected implements TheInternetFooterValidatable{
    public static TheInternetFooterExpected getInstance() {
        return new TheInternetFooterExpected();
    }

    @Override
    public String getMessage() {
        return "Powered by Elemental Selenium";
    }

    @Override
    public String getLinkText() {
        return "Elemental Selenium";
    }

    @Override
    public String getLinkHref() {
        return "http://elementalselenium.com/";
    }
}
