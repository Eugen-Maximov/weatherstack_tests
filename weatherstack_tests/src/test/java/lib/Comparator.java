package lib;

import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;

public class Comparator {

    private static SoftAssertions softly = new SoftAssertions();

    public static void equalCompare(Object expected, Object actual, String type) {
        softly.assertThat(expected).as(type).isEqualTo(actual);
    }

    public static void equalCompare(Object expected, Object actual) {
        softly.assertThat(expected).isEqualTo(actual);
    }

    public static void compareAll() {
        try {
            softly.assertAll();
        } catch (SoftAssertionError e) {
            System.out.println(e.getErrors());
            throw new SoftAssertionError(e.getErrors());
        }
    }
}
