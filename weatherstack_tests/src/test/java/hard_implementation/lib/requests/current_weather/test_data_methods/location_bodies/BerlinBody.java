package hard_implementation.lib.requests.current_weather.test_data_methods.location_bodies;

public class BerlinBody {

    private static final String json = "src/test/java/test_data/city_bodies/berlin_body.json";

    private BerlinBody() {}

    public static String getJson() {
        return json;
    }
}
