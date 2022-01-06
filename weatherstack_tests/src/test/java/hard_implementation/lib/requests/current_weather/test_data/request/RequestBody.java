package hard_implementation.lib.requests.current_weather.test_data.request;

public class RequestBody {

    private static final String json =
            "{\n" +
                    "  \"type\": \"City\",\n" +
                    "  \"query\": \"New York, United States of America\",\n" +
                    "  \"language\": \"en\",\n" +
                    "  \"unit\": \"m\"\n" +
                    "}";

    private RequestBody() {}

    public static String getJson() {
        return json;
    }
}
