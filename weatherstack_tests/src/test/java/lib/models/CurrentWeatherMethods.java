package lib.models;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.RestAssured;

import static lib.methods.APIAuth.getToken;
import static org.assertj.core.api.Assertions.assertThat;

public class CurrentWeatherMethods {

    private static final String REQUEST_PATH = "current";
    private String CITY_NAME;

    public CurrentWeatherMethods(String cityName) {
        this.CITY_NAME = cityName;
    }

    public CurrentWeatherMethods() {

    }

    @Step("Send request to weather in current city.")
    public CurrentWeatherModel sendRequestByCity() {
        String json = RestAssured
                .given()
                .queryParam("query", CITY_NAME)
                .queryParam("access_key", getToken())
                .get(REQUEST_PATH)
                .getBody()
                .asString();
        Gson g = new Gson();
        return g.fromJson(json, CurrentWeatherModel.class);
    }

    public void assertEqualResponseBodies(CurrentWeatherModel exampleModel, CurrentWeatherModel actualModel) {
        assertEqualRequest(exampleModel.getRequest(), actualModel.getRequest());
        assertEqualLocation(exampleModel.getLocation(), actualModel.getLocation());
        assertEqualCurrent(exampleModel.getCurrent(), actualModel.getCurrent());
    }

    private void assertEqualRequest(CurrentWeatherModel.Request exampleRequest, CurrentWeatherModel.Request actualRequest) {
        assertThat(actualRequest.getType()).isEqualTo(exampleRequest.getType());
        assertThat(actualRequest.getQuery()).isEqualTo(exampleRequest.getQuery());
        assertThat(actualRequest.getLanguage()).isEqualTo(exampleRequest.getLanguage());
        assertThat(actualRequest.getUnit()).isEqualTo(exampleRequest.getUnit());
    }

    private void assertEqualLocation(CurrentWeatherModel.Location exampleLocation, CurrentWeatherModel.Location actualLocation) {
        assertThat(actualLocation.getName()).isEqualTo(exampleLocation.getName());
        assertThat(actualLocation.getCountry()).isEqualTo(exampleLocation.getCountry());
        assertThat(actualLocation.getRegion()).isEqualTo(exampleLocation.getRegion());
        assertThat(actualLocation.getLat()).isEqualTo(exampleLocation.getLat());
        assertThat(actualLocation.getLon()).isEqualTo(exampleLocation.getLon());
        assertThat(actualLocation.getTimezoneId()).isEqualTo(exampleLocation.getTimezoneId());
        assertThat(actualLocation.getLocalTime()).isEqualTo(exampleLocation.getLocalTime());
        assertThat(actualLocation.getLocalTimeEpoch()).isEqualTo(exampleLocation.getLocalTimeEpoch());
        assertThat(actualLocation.getUtcOffset()).isEqualTo(exampleLocation.getUtcOffset());
    }

    private void assertEqualCurrent(CurrentWeatherModel.Current exampleCurrent, CurrentWeatherModel.Current actualCurrent) {
        assertThat(actualCurrent.getObservationTime()).isEqualTo(exampleCurrent.getObservationTime());
        assertThat(actualCurrent.getTemperature()).isEqualTo(exampleCurrent.getTemperature());
        assertThat(actualCurrent.getWeatherCode()).isEqualTo(exampleCurrent.getWeatherCode());
        assertThat(actualCurrent.getWeatherIcons()).isEqualTo(exampleCurrent.getWeatherIcons());
        assertThat(actualCurrent.getWeatherDescriptions()).isEqualTo(exampleCurrent.getWeatherDescriptions());
        assertThat(actualCurrent.getObservationTime()).isEqualTo(exampleCurrent.getObservationTime());
        assertThat(actualCurrent.getWindSpeed()).isEqualTo(exampleCurrent.getWindSpeed());
        assertThat(actualCurrent.getWindDegree()).isEqualTo(exampleCurrent.getWindDegree());
        assertThat(actualCurrent.getWindDir()).isEqualTo(exampleCurrent.getWindDir());
        assertThat(actualCurrent.getPressure()).isEqualTo(exampleCurrent.getPressure());
        assertThat(actualCurrent.getPrecip()).isEqualTo(exampleCurrent.getPrecip());
        assertThat(actualCurrent.getHumidity()).isEqualTo(exampleCurrent.getHumidity());
        assertThat(actualCurrent.getCloudCover()).isEqualTo(exampleCurrent.getCloudCover());
        assertThat(actualCurrent.getFeelsLike()).isEqualTo(exampleCurrent.getFeelsLike());
        assertThat(actualCurrent.getUvIndex()).isEqualTo(exampleCurrent.getUvIndex());
        assertThat(actualCurrent.getVisibility()).isEqualTo(exampleCurrent.getVisibility());
    }
}
