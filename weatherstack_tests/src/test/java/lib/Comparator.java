package lib;

import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.Assertions.assertThat;

public class Comparator extends CoreTestCase {

    private static SoftAssertions softly = new SoftAssertions();

    public static void equalCompare(Object expected, Object actual, String comment) {
        softly.assertThat(expected).as(comment).isEqualTo(actual);
    }

    public static void equalCompare(Object expected, Object actual) {
        softly.assertThat(expected).isEqualTo(actual);
    }

    public static void statusCodeAssert(int actualCode, int expectedCode, String comment) {
        assertThat(expectedCode).as(comment).isEqualTo(actualCode);
    }

    public static void statusCodeAssert(int actualCode, int expectedCode) {
        assertThat(expectedCode).isEqualTo(actualCode);
    }

    public void compareAll() throws Exception {
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            new AssertBodyLogger(testName.getMethodName() ,e.getErrors()).getAssertBodiesReportLogs();
            //throw new SoftAssertionError(e.getErrors());
        }
    }
}
