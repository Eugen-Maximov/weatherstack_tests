package hard_implementation.suites;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/features",
//        glue = "ru.savkk.test",
//        tags = "@all",
//        dryRun = false,
//        strict = true,
//        snippets = CucumberOptions.SnippetType.UNDERSCORE
////        name = "^Успешное|Успешная.*"
//)
@CucumberOptions(
        features = "src/test/resources",
        glue = "ru.savkk.test",
        tags = "@withdrawal",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {
}
