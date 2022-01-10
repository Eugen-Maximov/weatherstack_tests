package hard_implementation.lib.requests.current_weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.json.JsonException;
import hard_implementation.lib.Comparator;
import hard_implementation.lib.requests.errors.ErrorsMethods;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static hard_implementation.lib.Comparator.equalCompare;

public class CurrentWeatherResponseMethods {

    private static String checkedCity;

    @Step("Parse response body")
    public static CurrentWeatherModel parseCorrectBody(Response response) {
        String json = response.getBody().asString();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, CurrentWeatherModel.class);
        } catch (JsonProcessingException e) {
            ErrorsMethods.checkIsItError(response);
            throw new JsonException("Your request is incorrect. The answer belongs to the errors model class.\n" +
                    "Your body: " + json);
        }
    }

    @Step("Compare actual response body with expected body")
    public static void assertEqualResponseBodies(CurrentWeatherModel extendsModel, CurrentWeatherModel actualModel) {
        checkedCity = extendsModel.getLocation().getName();
        assertEqualRequest(extendsModel.getRequest(), actualModel.getRequest());
        assertEqualLocation(extendsModel.getLocation(), actualModel.getLocation());
        assertEqualCurrent(extendsModel.getCurrent(), actualModel.getCurrent());
        Comparator.compareAll();
    }

    @Step("Compare 'request' part of response body")
    private static void assertEqualRequest(CurrentWeatherModel.Request extendsRequest, CurrentWeatherModel.Request actualRequest) {
        equalCompare(extendsRequest.getType(), actualRequest.getType(), checkedCity + ".Request > type");
        equalCompare(extendsRequest.getQuery(), actualRequest.getQuery(), checkedCity + ".Request > query");
        equalCompare(extendsRequest.getLanguage(), actualRequest.getLanguage(), checkedCity + ".Request > language");
        equalCompare(extendsRequest.getUnit(), actualRequest.getUnit(), checkedCity + ".Request > unit");
    }

    @Step("Compare 'locations' part of response body")
    private static void assertEqualLocation(CurrentWeatherModel.Location extendsLocation, CurrentWeatherModel.Location actualLocation) {
        equalCompare(actualLocation.getName(), extendsLocation.getName(), checkedCity + ".Location > name");
        equalCompare(actualLocation.getCountry(), extendsLocation.getCountry(), checkedCity + ".Location > country");
        equalCompare(actualLocation.getRegion(), extendsLocation.getRegion(), checkedCity + ".Location > region");
        equalCompare(actualLocation.getLat(), extendsLocation.getLat(), checkedCity + ".Location > lat");
        equalCompare(actualLocation.getLon(), extendsLocation.getLon(), checkedCity + ".Location > lon");
        equalCompare(actualLocation.getTimezone_id(), extendsLocation.getTimezone_id(), checkedCity + ".Location > timezone_id");
        equalCompare(actualLocation.getLocaltime(), extendsLocation.getLocaltime(), checkedCity + ".Location > local_time");
        equalCompare(actualLocation.getLocaltime_epoch(), extendsLocation.getLocaltime_epoch(), checkedCity + ".Location > localTime_epoch");
        equalCompare(actualLocation.getUtc_offset(), extendsLocation.getUtc_offset(), checkedCity + ".Location > utf_offset");
    }

    @Step("Compare 'current' part of response body")
    private static void assertEqualCurrent(CurrentWeatherModel.Current extendsCurrent, CurrentWeatherModel.Current actualCurrent) {
        equalCompare(actualCurrent.getObservation_time(), extendsCurrent.getObservation_time(), checkedCity + ".Current > observation_time");
        equalCompare(actualCurrent.getTemperature(), extendsCurrent.getTemperature(), checkedCity + ".Current > temperature");
        equalCompare(actualCurrent.getWeather_code(), extendsCurrent.getWeather_code(), checkedCity + ".Current > weather_code");
        equalCompare(actualCurrent.getWeather_icons(), extendsCurrent.getWeather_icons(), checkedCity + ".Current > weather_icons");
        equalCompare(actualCurrent.getWeather_descriptions(), extendsCurrent.getWeather_descriptions(), checkedCity + ".Current > weather_descriptions");
        equalCompare(actualCurrent.getWind_speed(), extendsCurrent.getWind_speed(), checkedCity + ".Current > wind_speed");
        equalCompare(actualCurrent.getWind_degree(), extendsCurrent.getWind_degree(), checkedCity + ".Current > wind_degree");
        equalCompare(actualCurrent.getWind_dir(), extendsCurrent.getWind_dir(), checkedCity + ".Current > wind_dir");
        equalCompare(actualCurrent.getPressure(), extendsCurrent.getPressure(), checkedCity + ".Current > pressure");
        equalCompare(actualCurrent.getPrecip(), extendsCurrent.getPrecip(), checkedCity + ".Current > precip");
        equalCompare(actualCurrent.getHumidity(), extendsCurrent.getHumidity(), checkedCity + ".Current > humidity");
        equalCompare(actualCurrent.getCloudcover(), extendsCurrent.getCloudcover(), checkedCity + ".Current > cloud_cover");
        equalCompare(actualCurrent.getFeelslike(), extendsCurrent.getFeelslike(), checkedCity + ".Current > feels_like");
        equalCompare(actualCurrent.getUv_index(), extendsCurrent.getUv_index(), checkedCity + ".Current > uv_index");
        equalCompare(actualCurrent.getVisibility(), extendsCurrent.getVisibility(), checkedCity + ".Current > visibility");
        equalCompare(actualCurrent.getIs_day(), extendsCurrent.getIs_day(), checkedCity + ".Current > is_day");
    }
}
