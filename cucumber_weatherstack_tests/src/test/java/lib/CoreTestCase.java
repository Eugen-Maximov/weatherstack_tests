package lib;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import lib.methods.any_methods.Logger;
import lib.methods.any_methods.Comparator;

import java.util.List;

public class CoreTestCase {

    private Scenario scenario;
    protected static final String baseURL = "http://api.weatherstack.com";
    private String testName;

    @Before
    @Step("Set up test env")
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        testName = this.scenario.getName();
        setURI();
    }

    @After
    @Step("Reset test env")
    public void resetAll() {
        RestAssured.reset();
        checkLogs();
    }

    @Step("Set base URI for tests")
    protected void setURI() {
        RestAssured.baseURI = baseURL;
    }

    @Step("Set base URI: '{url}' for tests")
    private void setURI(String url) {
        RestAssured.baseURI = url;
    }

    @Step("Check logs for errors after test-run")
    private void checkLogs() {
        List<String> errors = Comparator.errorsList;
        if (Comparator.numOfErrors > 0) {
            Logger logger = new Logger(testName, errors);
            logger.getAssertBodiesReportLogs();
            Comparator.numOfErrors = 0;
            throw new AssertionError("After the test run, there were discrepancies in the values.\n" +
                    "Test failed. Additional information is available in the logs.");
        }
    }
}
