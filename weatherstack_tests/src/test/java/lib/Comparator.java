package lib;

import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Comparator {

    private static SoftAssertions softly = new SoftAssertions();
    public static int numOfLogs = 0;
    public static List<String> errorList = new ArrayList<>();

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

    public static void compareAll() {
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            ++numOfLogs;
            errorList = e.getErrors();
        }
    }
}
