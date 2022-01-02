package lib.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static lib.Comparator.*;
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
    public CurrentWeatherModel sendRequestByCity() throws IOException {
        Response response = getCurrentResponse();
        isRequestOk(response);
        String json = response
                .getBody()
                .asString();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, CurrentWeatherModel.class);
        } catch (JsonProcessingException e) {
            //e.printStackTrace();
            throw new IOException("There is unexpected response body.\n" + "Actual body: " + e.getMessage());
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
            spec = RestAssured.given().queryParam("query", cityName).queryParam("access_key", getToken());
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
    public void assertEqualResponseBodies(CurrentWeatherModel exampleModel, CurrentWeatherModel actualModel) {
        assertEqualRequest(exampleModel.getRequest(), actualModel.getRequest());
        assertEqualLocation(exampleModel.getLocation(), actualModel.getLocation());
        assertEqualCurrent(exampleModel.getCurrent(), actualModel.getCurrent());
        compareAll();
    }

    private void assertEqualRequest(CurrentWeatherModel.Request exampleRequest, CurrentWeatherModel.Request actualRequest) {
        equalCompare(exampleRequest.getType(), actualRequest.getType(), "Request type");
        equalCompare(exampleRequest.getQuery(), actualRequest.getQuery(), "Request query");
        equalCompare(exampleRequest.getQuery(), actualRequest.getLanguage(), "Request language");
        equalCompare(exampleRequest.getUnit(), actualRequest.getUnit(), "Request unit");
    }

    private void assertEqualLocation(CurrentWeatherModel.Location exampleLocation, CurrentWeatherModel.Location actualLocation) {
        equalCompare(actualLocation.getName(), exampleLocation.getName(), "Location name");
        equalCompare(actualLocation.getCountry(), exampleLocation.getCountry(), "Location country");
        equalCompare(actualLocation.getRegion(), exampleLocation.getRegion(), "Location region");
        equalCompare(actualLocation.getLat(), exampleLocation.getLat(), "Location lat");
        equalCompare(actualLocation.getLon(), exampleLocation.getLon(), "Location lon");
        equalCompare(actualLocation.getTimezoneId(), exampleLocation.getTimezoneId(), "Location timezone_id");
        equalCompare(actualLocation.getLocalTime(), exampleLocation.getLocalTime(), "Location local_time");
        equalCompare(actualLocation.getLocalTimeEpoch(), exampleLocation.getLocalTimeEpoch(), "Location localTime_epoch");
        equalCompare(actualLocation.getUtcOffset(), exampleLocation.getUtcOffset(), "Location utf_offset");
    }

    private void assertEqualCurrent(CurrentWeatherModel.Current exampleCurrent, CurrentWeatherModel.Current actualCurrent) {
        equalCompare(actualCurrent.getObservationTime(), exampleCurrent.getObservationTime(), "Current observation_time");
        equalCompare(actualCurrent.getTemperature(), exampleCurrent.getTemperature(), "Current temperature");
        equalCompare(actualCurrent.getWeatherCode(), exampleCurrent.getWeatherCode(), "Current weather_code");
        equalCompare(actualCurrent.getWeatherIcons(), exampleCurrent.getWeatherIcons(), "Current weather_icons");
        equalCompare(actualCurrent.getWeatherDescriptions(), exampleCurrent.getWeatherDescriptions(), "Current weather_descriptions");
        equalCompare(actualCurrent.getWindSpeed(), exampleCurrent.getWindSpeed(), "Current wind_speed");
        equalCompare(actualCurrent.getWindDegree(), exampleCurrent.getWindDegree(), "Current wind_degree");
        equalCompare(actualCurrent.getWindDir(), exampleCurrent.getWindDir(), "Current wind_dir");
        equalCompare(actualCurrent.getPressure(), exampleCurrent.getPressure(), "Current pressure");
        equalCompare(actualCurrent.getPrecip(), exampleCurrent.getPrecip(), "Current precip");
        equalCompare(actualCurrent.getHumidity(), exampleCurrent.getHumidity(), "Current humidity");
        equalCompare(actualCurrent.getCloudCover(), exampleCurrent.getCloudCover(), "Current cloud_cover");
        equalCompare(actualCurrent.getFeelsLike(), exampleCurrent.getFeelsLike(), "Current feels_like");
        equalCompare(actualCurrent.getUvIndex(), exampleCurrent.getUvIndex(), "Current uv_index");
        equalCompare(actualCurrent.getVisibility(), exampleCurrent.getVisibility(), "Current visibility");
    }
}
