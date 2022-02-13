package lib.methods.any_methods;

import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import lib.methods.API_methods.ResponseMethods;
import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class Comparator {

    private SoftAssertions softly;
    public static List<String> errorsList;
    public static int numOfErrors = 0;

    @Then("responses bodies match")
    @Step("Compare expected and actual results")
    public void compareResponsesBodies() {
        softly = new SoftAssertions();
        assertEqualsBodies();
        compareAll();
    }

    @Step("Compare bodies fields")
    private void assertEqualsBodies() {
        List<Object> actual = ResponseMethods.actualResponses;
        List<Object> expected = ExpectedResultCreator.expectedModels;
        List<String> modelNames = ExpectedResultCreator.names;
        for (Object o : actual) {
            int i = actual.indexOf(o);
            softly.assertThat(o)
                    .usingRecursiveComparison()
                    .as("Errors in expected model: " + modelNames.get(i))
                    .isEqualTo(expected.get(i));
        }
    }

    private void compareAll() {
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            ++numOfErrors;
            errorsList = e.getErrors();
        }
    }
}
