package lib.test_data.current_request.cities.cities_bodies;

public class NewYorkBody {

    private static final String json =
            "{\n" +
                    "  \"name\": \"New York\",\n" +
                    "  \"country\": \"United States of America\",\n" +
                    "  \"region\": \"New York\",\n" +
                    "  \"lat\": \"40.714\",\n" +
                    "  \"lon\": \"-74.006\",\n" +
                    "  \"timezone_id\": \"America/New_York\",\n" +
                    "  \"localtime\": \"{LOCAL_TIME}}\",\n" +
                    "  \"localtime_epoch\": 12345,\n" +
                    "  \"utc_offset\": \"-5.0\"\n" +
                    "}";

    private NewYorkBody() {}

    public static String getJson() {
        return json;
    }
}
