package hard_implementation.lib.requests.current_weather.test_data.location.location_bodies;

public class LondonBody {

    private static final String json =
            "{\n" +
                    "  \"name\": \"London\",\n" +
                    "  \"country\": \"United Kingdom\",\n" +
                    "  \"region\": \"City of London, Greater London\",\n" +
                    "  \"lat\": \"51.517\",\n" +
                    "  \"lon\": \"-0.106\",\n" +
                    "  \"timezone_id\": \"Europe/London\",\n" +
                    "  \"localtime\": \"{LOCAL_TIME}}\",\n" +
                    "  \"localtime_epoch\": 12345,\n" +
                    "  \"utc_offset\": \"0.0\"\n" +
                    "}";

    private LondonBody() {}

    public static String getJson() {
        return json;
    }
}
