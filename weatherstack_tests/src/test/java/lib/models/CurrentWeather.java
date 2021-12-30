package lib.models;

import com.google.gson.Gson;
import io.restassured.RestAssured;

import static lib.methods.APIAuth.getToken;

public class CurrentWeather {

    private static final String REQUEST_PATH = "current";
    private String CITY_NAME;

    public CurrentWeather(String cityName) {
        this.CITY_NAME = cityName;
    }

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

    public CurrentWeatherModel createModel() {
        CurrentWeatherModel model = new CurrentWeatherModel();
        model.setLocation(new CurrentWeatherModel.Location());
        model.getLocation().setName(CITY_NAME);
        return model;
    }
}
