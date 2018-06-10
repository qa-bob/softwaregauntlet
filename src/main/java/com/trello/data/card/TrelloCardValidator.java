package com.trello.data.card;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class TrelloCardValidator extends Calibrator {
    private static final String DESCRIPTION = "Trello Card";
    private final TrelloCardValidatable actual;
    private final TrelloCardValidatable expected;

    private TrelloCardValidator(TrelloCardDefinition expected, TrelloCard actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static TrelloCardValidator getInstance(TrelloCardDefinition expected, TrelloCard actual) {
        return new TrelloCardValidator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Title", expected.getTitle(), actual.getTitle());
        verify("List", expected.getList(), actual.getList());
    }
}
