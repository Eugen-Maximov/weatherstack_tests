package tests;


import lib.CoreTestCase;
import lib.requests.current_weather.CurrentWeatherModel;
import lib.requests.current_weather.CurrentWeatherResponseMethods;
import lib.requests.current_weather.RequestToCurrentWeather;
import lib.requests.current_weather.current_data.Cities;
import lib.requests.current_weather.current_data.CurrentExpectedModelBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.restassured.response.Response;
import org.junit.Test;

@Epic("Positive Tests")
public class PositiveTest extends CoreTestCase {

    @Test
    @Tag("Positive")
    @DisplayName("Current weather request for 4 cities")
    @Description("Current weather request for 4 cities: Moscow, New York, London, Berlin")
    public void testSendCurrentRequest() {
        for (Cities cityToTest : Cities.values()) {
            Response response = new RequestToCurrentWeather(cityToTest, true).sendRequestToCurrent();
            CurrentWeatherModel actualResult = CurrentWeatherResponseMethods.parseCorrectBody(response);
            CurrentWeatherModel expectedResult = new CurrentExpectedModelBuilder(cityToTest).createTestDataModel();
            CurrentWeatherResponseMethods.assertEqualResponseBodies(expectedResult, actualResult);
        }
    }
}
