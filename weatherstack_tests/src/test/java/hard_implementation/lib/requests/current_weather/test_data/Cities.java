package hard_implementation.lib.requests.current_weather.test_data;

import hard_implementation.lib.requests.current_weather.test_data.location.location_bodies.BerlinBody;
import hard_implementation.lib.requests.current_weather.test_data.location.location_bodies.LondonBody;
import hard_implementation.lib.requests.current_weather.test_data.location.location_bodies.MoscowBody;
import hard_implementation.lib.requests.current_weather.test_data.location.location_bodies.NewYorkBody;

import java.io.File;

public enum Cities {
    NEW_YORK("New York", "New York, United States of America", NewYorkBody.getJson(), NewYorkBody.getJsonPath()),
    MOSCOW("Moscow", "Moscow, Russia", MoscowBody.getJson(), NewYorkBody.getJsonPath()),
    BERLIN("Berlin", "Berlin, Germany", BerlinBody.getJson(), NewYorkBody.getJsonPath()),
    LONDON("London", "London, United Kingdom", LondonBody.getJson(), NewYorkBody.getJsonPath());

    private String name;
    private String query;
    private String locationJson;
    private File jsonPath;

    Cities(String name, String query, String json, File jsonPath) {
        this.query = query;
        this.name = name;
        this.locationJson = json;
        this.jsonPath = jsonPath;
    }

    public String getQuery() {
        return query;
    }

    public String getName() {
        return name;
    }

    public String getLocationJson() {
        return locationJson;
    }

    public File getJsonPath() {
        return jsonPath;
    }
}
