package hard_implementation.lib.requests.current_weather.test_data.location.location_bodies;

public class MoscowBody {

    private static final String json =
            "{\n" +
                    "  \"name\": \"Moscow\",\n" +
                    "  \"country\": \"Russia\",\n" +
                    "  \"region\": \"Moscow City\",\n" +
                    "  \"lat\": \"55.752\",\n" +
                    "  \"lon\": \"37.616\",\n" +
                    "  \"timezone_id\": \"Europe/Moscow\",\n" +
                    "  \"localtime\": \"{LOCAL_TIME}}\",\n" +
                    "  \"localtime_epoch\": 123456,\n" +
                    "  \"utc_offset\": \"3.0\"\n" +
                    "}";

    private MoscowBody() {}

    public static String getJson() {
        return json;
    }
}
