package lib.requests.current_weather.current_data;

import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.json.JsonException;
import lib.methods.TimeConverter;
import lib.requests.current_weather.CurrentWeatherModel;
import io.qameta.allure.Step;

import java.io.IOException;
import java.nio.file.Paths;

public class CurrentExpectedModelBuilder {

    private static Cities city;
    private static CurrentWeatherModel model;

    public CurrentExpectedModelBuilder(Cities cities) {
        CurrentExpectedModelBuilder.city = cities;
    }

    @Step("Create test data model")
    public CurrentWeatherModel createTestDataModel() {
        model = getBasicJsonModel();
        setDateToModel();
        setQueryToModel();
        return model;
    }

    private static CurrentWeatherModel getBasicJsonModel() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(Paths.get(city.getJson()).toFile(), CurrentWeatherModel.class);
        } catch (IOException e) {
            throw new JsonException("Cannot parse test data model from .json file" + e.getMessage());
        }
    }

    private static void setDateToModel() {
        String timezoneId = model.getLocation().getTimezone_id();
        TimeConverter timeConverter = new TimeConverter(timezoneId);
        model.getLocation().setLocaltime(timeConverter.getSimpleDate());
        model.getLocation().setLocaltime_epoch(timeConverter.getTimestamp());
    }

    private static void setQueryToModel() {
        String query = model.getLocation().getName() + ", " + model.getLocation().getCountry();
        model.getRequest().setQuery(query);
    }
}
