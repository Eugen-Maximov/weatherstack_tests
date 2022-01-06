package hard_implementation.lib.requests.current_weather.test_data_methods;

import hard_implementation.lib.requests.current_weather.test_data_methods.location_bodies.BerlinBody;
import hard_implementation.lib.requests.current_weather.test_data_methods.location_bodies.LondonBody;
import hard_implementation.lib.requests.current_weather.test_data_methods.location_bodies.MoscowBody;
import hard_implementation.lib.requests.current_weather.test_data_methods.location_bodies.NewYorkBody;

public enum Cities {
    NEW_YORK("New York", NewYorkBody.getJson()),
    MOSCOW("Moscow", MoscowBody.getJson()),
    BERLIN("Berlin", BerlinBody.getJson()),
    LONDON("London", LondonBody.getJson());

    private String name;
    private String jsonPath;

    Cities(String name, String jsonPath) {
        this.name = name;
        this.jsonPath = jsonPath;
    }

    public String getName() {
        return name;
    }

    public String getJsonPath() {
        return jsonPath;
    }
}
