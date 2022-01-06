package hard_implementation.lib.requests.current_weather.test_data_methods.location_bodies;

public class NewYorkBody {

    private static final String json = "src\\test\\java\\test_data\\city_bodies\\new_york_body.json";

    private NewYorkBody() {}

    public static String getJson() {
        return json;
    }
}
