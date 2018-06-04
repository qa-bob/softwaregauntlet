/*Copyright 2017 Craig A. Stockton

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.*/
package com.softwareonpurpose.gauntlet;

import com.softwareonpurpose.coverage4test.CoverageReport;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.driver.DefaultIeInstantiation;
import com.softwareonpurpose.validator4test.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class GauntletTest {

    private final CoverageReport report;
    private final String classname;
    private Logger logger;
    private String testMethodName;
    private String requirements;
    private boolean areRequirementsTraced;

    protected GauntletTest() {
        this.classname = this.getClass().getSimpleName();
        report = CoverageReport.construct(classname);
        Validator.setStyle(Validator.ValidationLoggingStyle.BDD);
        initializeUiHost();
    }

    private void initializeUiHost() {
        String browser = System.getProperty("host");
        if (browser != null) {
            switch (browser) {
                case "ie":
                    UiHost.setDriverInstantiation(DefaultIeInstantiation.getInstance());
                default:
            }
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void beginExecution(Method method) {
        testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void terminateExecution(ITestResult result) {
        UiHost.quitInstance();
        addCoverage(result);
    }

    private void addCoverage(ITestResult result) {
        String scenario = compileScenario(result);
        setRequirements(null);
    }

    private String compileScenario(ITestResult result) {
        if (result.getParameters().length == 0) {
            return null;
        }
        StringBuilder scenario = new StringBuilder();
        for (Object participant : result.getParameters()) {
            String participantDescription = participant.toString();
            String formattedDescription = participantDescription.substring(0, 1).equals("{") ? participantDescription
                    : String.format("{%s}", participantDescription);
            scenario.append(formattedDescription);
        }
        return scenario.toString();
    }

    @AfterClass(alwaysRun = true)
    public void writeCoverageReport() {
        if (areRequirementsTraced) {
        }
    }

    @SuppressWarnings("unused")
    protected void given(Object... testDataDefinitions) {
        String label = "GIVEN";
        for (Object testDataDefinition : testDataDefinitions) {
            getLogger().info(String.format("%s: %s", label, testDataDefinition.toString()));
            label = "  AND";
        }
    }

    @SuppressWarnings("unused")
    protected void when() {
        getLogger().info("");
        getLogger().info("WHEN:");
    }

    @SuppressWarnings("unused")
    protected void then(String testResult) {
        confirm(testResult);
    }

    @SuppressWarnings("WeakerAccess")
    protected void confirm(String testResult) {
        Assert.assertTrue(testResult.equals(Validator.PASS), testResult);
        getLogger().info(String.format("%n==========   '%s' test completed successfully   ==========%n",
                getTestMethodName()));
    }

    private String getTestMethodName() {
        return testMethodName;
    }

    private Logger getLogger() {
        if (logger == null) {
            logger = LoggerFactory.getLogger("");
        }
        return logger;
    }

    @SuppressWarnings("WeakerAccess")
    protected void setRequirements(@SuppressWarnings("SameParameterValue") String requirements) {
        this.requirements = requirements;
    }

    @SuppressWarnings("unused")
    protected class TestType {

        public static final String EVT = "evt";                 //  Environment Validation Test
        public static final String DEV = "under_development";   //  Test being developed and/or debugged
        public static final String PRODUCTION = "production";   //  Benign (alters NO data) executable in Production
        public static final String RELEASE = "release";         //  Test critical to validating Release Readiness
        public static final String SPRINT = "sprint";           //  Validates acceptance criteria for current sprint
    }

    /**
     * Names of Applications under test
     */
    @SuppressWarnings("unused")
    public class Application {
        public static final String TRELLO = "trello_app";

        //  public final static String APPLICATION_NAME = "[application name]";
    }

    /**
     * Names of Views from applications under test
     */
    @SuppressWarnings("unused")
    public class View {
        public static final String CARD_MOVE = "card_move_view";
        public static final String CARD = "card_view";
        public static final String LANDING = "landing_view";
        public static final String LOGIN = "login_view";
        public static final String BOARD = "board_view";

        //  public final static String VIEW_NAME = "[view name]";
    }

    /**
     * Names of Data Entities supporting applications under test
     */
    @SuppressWarnings("unused")
    public class DataEntity {
        public static final String CARD = "card_data";

        //  public final static String DATABASE_NAME = "[database name]";
    }

    /**
     * Validation targets
     */
    @SuppressWarnings("unused")
    public class TestSubject {

        public static final String VIEW = "view";
        public static final String DATA_ENTITY = "[data_entity_name]";
    }
}
