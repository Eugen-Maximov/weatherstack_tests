package lib.methods;

import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class Comparator {

    private SoftAssertions softly;

    @Then("responses bodies match")
    public void compareResponsesBodies() {
        softly = new SoftAssertions();
        assertEqualsBodies();
        softly.assertAll();
    }

    private void assertEqualsBodies() {
        List<Object> actual = ResponseMethods.actualResponses;
        List<Object> expected = ExpectedResultCreator.expectedModels;
        for (Object o : actual) {
            int i = actual.indexOf(o);
            softly.assertThat(o.equals(expected.get(i))).isTrue();
        }
    }
}
