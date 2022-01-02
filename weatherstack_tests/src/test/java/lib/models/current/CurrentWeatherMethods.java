package lib.models.current;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.json.JsonException;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lib.Comparator;
import lib.models.errors.ErrorsMethods;

import static lib.Comparator.equalCompare;
import static lib.Comparator.statusCodeAssert;
import static lib.methods.APIAuth.getToken;

public class CurrentWeatherMethods {

    private static final String REQUEST_PATH = "current";
    private String cityName;
    private boolean isCity = false;
    private boolean isAuth = false;

    public CurrentWeatherMethods(String cityName) {
        this.cityName = cityName;
        this.isCity = true;
    }

    public CurrentWeatherMethods(String cityName, boolean isAuth) {
        this.cityName = cityName;
        this.isCity = true;
        this.isAuth = isAuth;
    }

    public CurrentWeatherMethods() {
    }

    @Step("Send request to weather in current city and get actual response body")
    public CurrentWeatherModel sendRequestByCity() {
        Response response = getCurrentResponse();
        isRequestOk(response);
        String json = response
                .getBody()
                .asString();
        return parseJsonBody(json);
    }

    private CurrentWeatherModel parseJsonBody(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, CurrentWeatherModel.class);
        } catch (JsonProcessingException e) {
            ErrorsMethods.checkIsItError(json);
            throw new JsonException("Your request is incorrect. The answer belongs to the errors model class.\n" +
                    "Your body: " + json);
        }
    }

    @Step("Checking that response status code is 200 OK")
    public void isRequestOk(Response response) {
        int actualCode = response.getStatusCode();
        statusCodeAssert(actualCode, 200, "Current response status code");
    }

    private Response getCurrentResponse() {
        RequestSpecification spec = getSpecByCityOrAuth(isCity, isAuth);
        return RestAssured
                .given()
                .spec(spec)
                .get(REQUEST_PATH);
    }

    private RequestSpecification getSpecByCityOrAuth(boolean isCity, boolean isAuth) {
        RequestSpecification spec;
        if (isCity && isAuth) {
            spec = RestAssured.given().queryParam("access_key", getToken()).queryParam("query", cityName);
        } else if (!isCity && !isAuth) {
            spec = RestAssured.given();
        } else if (isAuth) {
            spec = RestAssured.given().queryParam("access_key", getToken());
        } else {
            spec = RestAssured.given().queryParam("query", cityName);
        }
        return spec;
    }

    @Step("Compare actual response body with expected body")
    public void assertEqualResponseBodies(CurrentWeatherModel exampleModel, CurrentWeatherModel actualModel) throws Exception {
        assertEqualRequest(exampleModel.getRequest(), actualModel.getRequest());
        assertEqualLocation(exampleModel.getLocation(), actualModel.getLocation());
        assertEqualCurrent(exampleModel.getCurrent(), actualModel.getCurrent());
        new Comparator().compareAll();
    }

    @Step("Compare 'request' part of response body")
    private void assertEqualRequest(CurrentWeatherModel.Request exampleRequest, CurrentWeatherModel.Request actualRequest) {
        equalCompare(exampleRequest.getType(), actualRequest.getType(), "Request > type");
        equalCompare(exampleRequest.getQuery(), actualRequest.getQuery(), "Request > query");
        equalCompare(exampleRequest.getLanguage(), actualRequest.getLanguage(), "Request > language");
        equalCompare(exampleRequest.getUnit(), actualRequest.getUnit(), "Request > unit");
    }

    @Step("Compare 'locations' part of response body")
    private void assertEqualLocation(CurrentWeatherModel.Location exampleLocation, CurrentWeatherModel.Location actualLocation) {
        equalCompare(actualLocation.getName(), exampleLocation.getName(), "Location > name");
        equalCompare(actualLocation.getCountry(), exampleLocation.getCountry(), "Location > country");
        equalCompare(actualLocation.getRegion(), exampleLocation.getRegion(), "Location > region");
        equalCompare(actualLocation.getLat(), exampleLocation.getLat(), "Location > lat");
        equalCompare(actualLocation.getLon(), exampleLocation.getLon(), "Location > lon");
        equalCompare(actualLocation.getTimezone_id(), exampleLocation.getTimezone_id(), "Location > timezone_id");
        equalCompare(actualLocation.getLocaltime(), exampleLocation.getLocaltime(), "Location > local_time");
        equalCompare(actualLocation.getLocaltime_epoch(), exampleLocation.getLocaltime_epoch(), "Location > localTime_epoch");
        equalCompare(actualLocation.getUtc_offset(), exampleLocation.getUtc_offset(), "Location > utf_offset");
    }

    @Step("Compare 'current' part of response body")
    private void assertEqualCurrent(CurrentWeatherModel.Current exampleCurrent, CurrentWeatherModel.Current actualCurrent) {
        equalCompare(actualCurrent.getObservation_time(), exampleCurrent.getObservation_time(), "Current > observation_time");
        equalCompare(actualCurrent.getTemperature(), exampleCurrent.getTemperature(), "Current > temperature");
        equalCompare(actualCurrent.getWeather_code(), exampleCurrent.getWeather_code(), "Current > weather_code");
        equalCompare(actualCurrent.getWeather_icons(), exampleCurrent.getWeather_icons(), "Current > weather_icons");
        equalCompare(actualCurrent.getWeather_descriptions(), exampleCurrent.getWeather_descriptions(), "Current > weather_descriptions");
        equalCompare(actualCurrent.getWind_speed(), exampleCurrent.getWind_speed(), "Current > wind_speed");
        equalCompare(actualCurrent.getWind_degree(), exampleCurrent.getWind_degree(), "Current > wind_degree");
        equalCompare(actualCurrent.getWind_dir(), exampleCurrent.getWind_dir(), "Current > wind_dir");
        equalCompare(actualCurrent.getPressure(), exampleCurrent.getPressure(), "Current > pressure");
        equalCompare(actualCurrent.getPrecip(), exampleCurrent.getPrecip(), "Current > precip");
        equalCompare(actualCurrent.getHumidity(), exampleCurrent.getHumidity(), "Current > humidity");
        equalCompare(actualCurrent.getCloudcover(), exampleCurrent.getCloudcover(), "Current > cloud_cover");
        equalCompare(actualCurrent.getFeelslike(), exampleCurrent.getFeelslike(), "Current > feels_like");
        equalCompare(actualCurrent.getUv_index(), exampleCurrent.getUv_index(), "Current > uv_index");
        equalCompare(actualCurrent.getVisibility(), exampleCurrent.getVisibility(), "Current > visibility");
        equalCompare(actualCurrent.getIs_day(), exampleCurrent.getIs_day(), "Current > is_day");
    }
}
