package com.herokuapp.theinternet.region.header;

import com.softwareonpurpose.gauntlet.environment.Environment;

public class TheInternetHeaderExpected implements TheInternetHeaderValidatable {
    public static TheInternetHeaderExpected getInstance() {
        return new TheInternetHeaderExpected();
    }

    @Override
    public String getImageSource() {
        return String.format("%s/%s", Environment.getInstance().getDomainUri(), "img/forkme_right_green_007200.png");
    }

    @Override
    public String getAlternateText() {
        return "Fork me on GitHub";
    }
}
