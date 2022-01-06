package hard_implementation.lib.requests.current_weather.test_data_methods.location_bodies;

public class LondonBody {

    private static final String json = "src/test/java/test_data/city_bodies/london_body.json";

    private LondonBody() {}

    public static String getJson() {
        return json;
    }
}
