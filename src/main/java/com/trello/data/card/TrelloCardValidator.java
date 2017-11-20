package com.trello.data.card;

import com.softwareonpurpose.validator4test.Validator;

public class TrelloCardValidator extends Validator {
    private static final String DESCRIPTION = "Trello Card";
    private final TrelloCardValidatable actual;
    private final TrelloCardValidatable expected;

    private TrelloCardValidator(TrelloCardDefinition expected, TrelloCard actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    @Override
    protected void executeVerifications() {
        verify("Title", expected.getTitle(), actual.getTitle());
        verify("List", expected.getList(), actual.getList());
    }

    public static TrelloCardValidator getInstance(TrelloCardDefinition expected, TrelloCard actual) {
        return new TrelloCardValidator(expected, actual);
    }
}
