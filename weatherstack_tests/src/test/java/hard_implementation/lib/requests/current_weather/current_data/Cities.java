package hard_implementation.lib.requests.current_weather.current_data;

public enum Cities {
    NEW_YORK("New York", "src/test/java/test_data/city_bodies/new_york_body.json"),
    MOSCOW("Moscow", "src/test/java/test_data/city_bodies/moscow_body.json"),
    BERLIN("Berlin", "src/test/java/test_data/city_bodies/berlin_body.json"),
    LONDON("London", "src/test/java/test_data/city_bodies/london_body.json");

    private String name;
    private String jsonPath;

    Cities(String name, String jsonFile) {
        this.name = name;
        this.jsonPath = jsonFile;
    }

    public String getName() {
        return name;
    }

    public String getJson() {
        return jsonPath;
    }
}
