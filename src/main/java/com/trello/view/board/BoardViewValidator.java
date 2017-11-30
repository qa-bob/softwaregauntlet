package com.trello.view.board;

import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.validator4test.Validator;
import com.trello.view.region.header.TrelloHeaderValidator;

public class BoardViewValidator extends Validator {
    private static final String DESCRIPTION = "'Board' view";

    private BoardViewValidator(BoardViewExpected expected, BoardView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addChildValidator(TrelloHeaderValidator.getInstance(expected.inHeader(), actual.inHeader(), this));
        UiRegion.suppressConstructionLogging(false);
    }

    public static BoardViewValidator getInstance(BoardViewExpected expected, BoardView actual) {
        return new BoardViewValidator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
