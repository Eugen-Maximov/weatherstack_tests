package lib.test_data.current_request.cities;

import lib.test_data.current_request.cities.cities_bodies.BerlinBody;
import lib.test_data.current_request.cities.cities_bodies.LondonBody;
import lib.test_data.current_request.cities.cities_bodies.MoscowBody;
import lib.test_data.current_request.cities.cities_bodies.NewYorkBody;

public enum Cities {
    NEW_YORK("New York", "New York, United States of America", NewYorkBody.getJson()),
    MOSCOW("Moscow", "Moscow, Russia", MoscowBody.getJson()),
    BERLIN("Berlin", "Berlin, Germany", BerlinBody.getJson()),
    LONDON("London", "London, United Kingdom", LondonBody.getJson());

    private String name;
    private String query;
    private String locationJson;

    Cities(String name, String query, String json) {
        this.query = query;
        this.name = name;
        this.locationJson = json;
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
}
