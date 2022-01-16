package hard_implementation.lib.requests.current_weather;

import hard_implementation.lib.requests.GetRequest;
import hard_implementation.lib.requests.SpecCreator;
import hard_implementation.lib.requests.current_weather.current_data.Cities;
import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestToCurrentWeather {

    private static final String REQUEST_PATH = "current";

    private static String cityName;
    private static RequestSpecification requestSpecification = RestAssured.given();
    private static SpecCreator specCreator;

    public RequestToCurrentWeather(Cities cityToRequest, boolean isAuth) {
        setCityName(cityToRequest);
        specCreator = new SpecCreator(cityName, isAuth);
    }

    public RequestToCurrentWeather(Cities cityToRequest) {
        setCityName(cityToRequest);
        specCreator = new SpecCreator(cityName);
    }

    public RequestToCurrentWeather(boolean isAuth) {
        specCreator = new SpecCreator(isAuth);
    }

    public RequestToCurrentWeather() {
    }

    @Когда("отправить get запрос на получение погоды по выбранному городу")
    @Step("Send GET request to /current weather")
    public Response sendRequestToCurrent() {
        requestSpecification = specCreator.getSpecification();
        GetRequest request = new GetRequest(requestSpecification);
        return request.sendGetRequest(REQUEST_PATH);
    }

    protected static String getRequestPath() {
        return REQUEST_PATH;
    }

    @Step("Set city to send request")
    private static void setCityName(Cities city) {
        RequestToCurrentWeather.cityName = city.getName();
    }
}
