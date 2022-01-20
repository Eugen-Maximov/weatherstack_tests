package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.NegativeTest;
import tests.PositiveTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PositiveTest.class,
        NegativeTest.class
})
public class RegressionSuite {}
