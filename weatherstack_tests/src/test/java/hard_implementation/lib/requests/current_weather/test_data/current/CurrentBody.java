package hard_implementation.lib.requests.current_weather.test_data.current;

public class CurrentBody {

    private static final String json =
            "{\n" +
                    "  \"observation_time\": \"01:58 PM\",\n" +
                    "  \"temperature\": 11,\n" +
                    "  \"weather_code\": 143,\n" +
                    "  \"weather_icons\": [\n" +
                    "    \"https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0006_mist.png\"\n" +
                    "  ],\n" +
                    "  \"weather_descriptions\": [\n" +
                    "    \"Mist\"\n" +
                    "  ],\n" +
                    "  \"wind_speed\": 0,\n" +
                    "  \"wind_degree\": 0,\n" +
                    "  \"wind_dir\": \"N\",\n" +
                    "  \"pressure\": 1001,\n" +
                    "  \"precip\": 0,\n" +
                    "  \"humidity\": 93,\n" +
                    "  \"cloudcover\": 100,\n" +
                    "  \"feelslike\": 10,\n" +
                    "  \"uv_index\": 1,\n" +
                    "  \"visibility\": 8,\n" +
                    "  \"is_day\": \"yes\"\n" +
                    "}";

    private CurrentBody() {}

    public static String getJson() {
        return json;
    }
}
