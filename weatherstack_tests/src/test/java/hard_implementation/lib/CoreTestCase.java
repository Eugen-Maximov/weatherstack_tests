package hard_implementation.lib;


import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.List;

public class CoreTestCase {

    /*
    environment TOKEN for debug = 1ad6d6000b35dffa30ed6e17ec33b366
     */
    
    @Before
    public void setUp() {
        setDefaultUri();
    }

    @After
    public void tearDown() {
        RestAssured.reset();
        checkLogsForErrors();
    }

    @Rule
    public TestName testName = new TestName();

    protected void setDefaultUri() {
        RestAssured.baseURI = "http://api.weatherstack.com";
        //RestAssured.baseURI = System.getenv("URI");
    }

    @Step("Checking that no error logs were generated during the tests")
    private void checkLogsForErrors() {
        List<List<String>> errors = new ArrayList<>(Comparator.errorLogs);
        if (errors.size() > 0) {
            for (List<String> list : errors) {
                new AssertBodyLogger(testName.getMethodName(), list);
                AssertBodyLogger.getAssertBodiesReportLogs();
            }
            throw new AssertionError("After the test run, there were discrepancies in the values.\n" +
                    "Test failed. Additional information is available in the logs.");
        }
    }
}
