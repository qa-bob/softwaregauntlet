package com.trello.view.board;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups={GauntletTest.Application.TRELLO, GauntletTest.View.BOARD})
public class BoardTest extends GauntletTest {
    public void smoke(){
        confirm("fail");
    }
}
