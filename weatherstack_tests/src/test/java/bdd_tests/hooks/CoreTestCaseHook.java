package bdd_tests.hooks;

import lib.CoreTestCase;
import io.cucumber.java.Before;

public class CoreTestCaseHook {

    @Before
    public void prepareTests() {
        CoreTestCase.setUp();
    }
}
