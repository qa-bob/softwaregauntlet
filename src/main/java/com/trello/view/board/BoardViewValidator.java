package com.trello.view.board;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.trello.view.region.header.TrelloHeaderCalibrator;

public class BoardViewValidator extends Calibrator {
    private static final String DESCRIPTION = "'Board' view";

    private BoardViewValidator(BoardViewExpected expected, BoardView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addChildCalibrator(TrelloHeaderCalibrator.getInstance(expected.inHeader(), actual.inHeader(), this));
        UiRegion.suppressConstructionLogging(false);
    }

    public static BoardViewValidator getInstance(BoardViewExpected expected, BoardView actual) {
        return new BoardViewValidator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
