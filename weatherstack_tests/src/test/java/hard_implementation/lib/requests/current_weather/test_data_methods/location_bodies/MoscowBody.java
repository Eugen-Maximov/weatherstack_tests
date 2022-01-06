package hard_implementation.lib.requests.current_weather.test_data_methods.location_bodies;

public class MoscowBody {

    private static final String json = "src/test/java/test_data/city_bodies/moscow_body.json";

    private MoscowBody() {}

    public static String getJson() {
        return json;
    }
}
