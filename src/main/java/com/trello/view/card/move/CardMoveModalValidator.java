package com.trello.view.card.move;

import com.softwareonpurpose.validator4test.Validator;

public class CardMoveModalValidator extends Validator {
    private static final String DESCRIPTION = "'Card Move' modal";
    private final CardMoveModalValidatable expected;
    private final CardMoveModalValidatable actual;

    private CardMoveModalValidator(CardMoveModalExpected expected, CardMoveModal actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static CardMoveModalValidator getInstance(CardMoveModalExpected expected, CardMoveModal actual) {
        return new CardMoveModalValidator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Title", expected.getTitle(), actual.getTitle());
        verify("'Board' label", expected.getBoardLabel(), actual.getBoardLabel());
        verify("Board", expected.getBoard(), actual.getBoard());
        verify("'List' label", expected.getListLabel(), actual.getListLabel());
        verify("List", expected.getList(), actual.getList());
        verify("'Position' label", expected.getPositionLabel(), actual.getPositionLabel());
        verify("'Move button' label", expected.getMoveButtonLabel(), actual.getMoveButtonLabel());
    }
}
