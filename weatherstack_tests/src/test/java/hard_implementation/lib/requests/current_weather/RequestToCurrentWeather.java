package hard_implementation.lib.requests.current_weather;

import hard_implementation.API.APIAuth;
import hard_implementation.lib.requests.current_weather.current_data.Cities;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestToCurrentWeather {

    private static final String REQUEST_PATH = "current";

    private static Cities city;
    private static String cityName;
    private static boolean isAuth;
    private static RequestSpecification requestSpecification = RestAssured.given();
    private static RequestSpecification authSpec;
    private static RequestSpecification querySpec;

    public RequestToCurrentWeather(Cities cityToRequest, boolean isAuth) {
        RequestToCurrentWeather.city = cityToRequest;
        setCityName(city.getName());
        RequestToCurrentWeather.isAuth = isAuth;
        setSpecs();
    }

    public RequestToCurrentWeather(Cities cityToRequest) {
        RequestToCurrentWeather.city = cityToRequest;
        setCityName(city.getName());
        setSpecs();
    }

    public RequestToCurrentWeather(boolean isAuth) {
        RequestToCurrentWeather.isAuth = isAuth;
        setSpecs();
    }

    public RequestToCurrentWeather() {
    }

    @Step("Send GET request to /current weather")
    public Response sendRequestToCurrent() {
        return RestAssured
                .given()
                .spec(requestSpecification)
                .get(REQUEST_PATH);
    }

    protected static String getRequestPath() {
        return REQUEST_PATH;
    }

    protected static Cities getCity() {
        return city;
    }

    @Step("Set city to send request")
    private static void setCityName(String cityName) {
        RequestToCurrentWeather.cityName = cityName;
    }

    private static void setSpecs() {
        setAuthToRequestSpec();
        setCityToRequestSpec();
        mergeSpecs();
    }

    private static void setAuthToRequestSpec() {
        if (isAuth) authSpec = APIAuth.authUser();
    }

    private static void setCityToRequestSpec() {
        if (cityName != null) {
            querySpec = RestAssured
                    .given()
                    .queryParam("query", cityName);
        }
    }

    private static void mergeSpecs() {
        if (authSpec != null && querySpec != null) {
            requestSpecification = RestAssured
                    .given()
                    .spec(authSpec)
                    .spec(querySpec);
        }
    }
}
