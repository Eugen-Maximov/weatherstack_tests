package suites;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:Feature",
        glue = {"hard_implementation.bdd_tests.tests", "hard_implementation.bdd_tests.hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberIntegrationTest {
}
