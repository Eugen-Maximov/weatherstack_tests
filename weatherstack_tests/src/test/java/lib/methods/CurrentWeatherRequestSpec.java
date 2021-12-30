package lib.methods;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class CurrentWeatherRequestSpec {

    private static final String METHOD_PATH = "/current";

    @Step("Send /current request by '{cityName}' city")
    public static RequestSpecification getCurrentWeatherByCity(String cityName) {
        return RestAssured
                .given()
                .queryParam("query", cityName);
    }
}
