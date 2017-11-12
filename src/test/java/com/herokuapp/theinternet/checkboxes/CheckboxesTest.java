package com.herokuapp.theinternet.checkboxes;

import com.herokuapp.data.DataEntity;
import com.herokuapp.data.DataEntityDescription;
import com.herokuapp.data.DataEntityProvider;
import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.THE_INTERNET, GauntletTest.View.CHECKBOXES})
public class CheckboxesTest extends GauntletTest {

    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{{DataEntityDescription.getInstance().withCheckbox1Selections(2).withCheckbox2Selections
                (0)}, {DataEntityDescription.getInstance().withCheckbox1Selections(3).withCheckbox2Selections(0)},
                {DataEntityDescription.getInstance().withCheckbox1Selections(8).withCheckbox2Selections(0)},
                {DataEntityDescription.getInstance().withCheckbox1Selections(0).withCheckbox2Selections(1)},
                {DataEntityDescription.getInstance().withCheckbox1Selections(3).withCheckbox2Selections(2)},
                {DataEntityDescription.getInstance().withCheckbox1Selections(6).withCheckbox2Selections(6)}};
    }

    @Test(groups = {TestType.EVT})
    public void smoke() {
        setRequirements("SysID9000.US8000");
        DataEntityDescription dataEntityDescription = DataEntityDescription.getInstance().withCheckbox1Selections(0)
                .withCheckbox2Selections(0);
        given(dataEntityDescription);
        DataEntity testData = DataEntityProvider.getInstance().get(dataEntityDescription);
        CheckboxesViewExpected expected = CheckboxesViewExpected.getInstance(testData.getCheckbox1Selections(),
                testData.getCheckbox1Selections());
        when();
        CheckboxesView actual = CheckboxesView.directNav();
        then(CheckboxesViewValidator.getInstance(expected, actual).validate());
    }

    @Test(groups = {TestType.SPRINT}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void selectCheckboxes(DataEntityDescription dataScenario) {
        setRequirements("SysID9000.US8000|SysID9000.US8001|SysID9001.US8002");
        given(dataScenario);
        DataEntity testData = DataEntityProvider.getInstance().get(dataScenario);
        Integer checkbox1Selections = testData.getCheckbox1Selections();
        Integer checkbox2Selections = testData.getCheckbox2Selections();
        CheckboxesViewExpected expected = CheckboxesViewExpected.getInstance(checkbox1Selections, checkbox2Selections);
        when();
        CheckboxesView actual = CheckboxesView.directNav().select(1, checkbox1Selections).select(2,
                checkbox2Selections);
        then(CheckboxesViewValidator.getInstance(expected, actual).validate());
    }
}
