package lib.test_data.current_request.cities;

public enum Cities {
    NEW_YORK("New York", "New York, United States of America"),
    MOSCOW("Moscow", "Moscow, Russia"),
    BERLIN("Berlin", "Berlin, Germany"),
    LONDON("London", "London, United Kingdom");

    private String name;
    private String query;

    Cities(String name, String query) {
        this.query = query;
        this.name = name;
    }

    public String getQuery() {
        return query;
    }

    public String getName() {
        return name;
    }
}
