package hard_implementation.lib.requests.current_weather.test_data_methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.json.JsonException;
import hard_implementation.lib.methods.TimeConverter;
import hard_implementation.lib.requests.current_weather.current.CurrentWeatherModel;

import java.io.IOException;
import java.nio.file.Paths;

public class CurrentTestDataBuilder {

    private static Cities city;
    private static CurrentWeatherModel model;

    public CurrentTestDataBuilder(Cities cities) {
        CurrentTestDataBuilder.city = cities;
    }

    public CurrentWeatherModel createTestDataModel() {
        model = getBasicJsonModel();
        setDateToModel();
        setQueryToModel();
        return model;
    }

    private static CurrentWeatherModel getBasicJsonModel() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(Paths.get(city.getJsonPath()).toFile(), CurrentWeatherModel.class);
        } catch (IOException e) {
            throw new JsonException("Cannot parse test data model from .json file" + e.getMessage());
        }
    }

    private static void setDateToModel() {
        String timezoneId = model.getLocation().getTimezone_id();
        Object[] timeAndDate = TimeConverter.getTimeAndDateByTimezone(timezoneId);
        model.getLocation().setLocaltime(String.valueOf(timeAndDate[0]));
        model.getLocation().setLocaltime_epoch((long) timeAndDate[1]);
    }

    private static void setQueryToModel() {
        String query = model.getLocation().getName() + ", " + model.getLocation().getCountry();
        model.getRequest().setQuery(query);
    }
}
