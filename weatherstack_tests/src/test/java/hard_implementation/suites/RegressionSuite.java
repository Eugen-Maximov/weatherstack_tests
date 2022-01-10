package hard_implementation.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import hard_implementation.tests.NegativeTest;
import hard_implementation.tests.PositiveTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PositiveTest.class,
        NegativeTest.class
})
public class RegressionSuite {}
