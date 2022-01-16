package hard_implementation.bdd_tests.hooks;

import hard_implementation.lib.CoreTestCase;
import io.cucumber.java.Before;

public class CoreTestCaseHook {

    @Before
    public void prepareTests() {
        CoreTestCase.setUp();
    }
}
