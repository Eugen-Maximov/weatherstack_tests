package lib.data;

import java.io.File;
import java.nio.file.Paths;

public enum CitiesExamples {

    NEW_YORK("New York", "src/test/resources/city_bodies/new_york_body.json"),
    MOSCOW("Moscow", "src/test/resources/city_bodies/moscow_body.json"),
    BERLIN("Berlin", "src/test/resources/city_bodies/berlin_body.json"),
    LONDON("London", "src/test/resources/city_bodies/london_body.json");

    private String name;
    private String jsonPath;

    CitiesExamples(String name, String jsonFile) {
        this.name = name;
        this.jsonPath = jsonFile;
    }

    public String getName() {
        return name;
    }

    public File getJson() {
        return Paths.get(jsonPath).toFile();
    }
}
