package com.trello.view.card.copy;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class CardCopyModalValidator extends Calibrator {
    private static final String DESCRIPTION = "Copy View";

    protected CardCopyModalValidator(CardCopyModalExpected expected, CardCopyModal actual) {
        super(DESCRIPTION, expected, actual);
    }

    public static CardCopyModalValidator getInstance(CardCopyModalExpected expected, CardCopyModal actual) {
        return new CardCopyModalValidator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
