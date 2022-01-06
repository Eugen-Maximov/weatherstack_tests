package hard_implementation.tests;


import hard_implementation.lib.CoreTestCase;
import hard_implementation.lib.requests.current_weather.RequestToCurrentWeather;
import hard_implementation.lib.requests.current_weather.current.CurrentWeatherModel;
import hard_implementation.lib.requests.current_weather.current.CurrentWeatherResponseMethods;
import hard_implementation.lib.requests.current_weather.test_data_methods.Cities;
import hard_implementation.lib.requests.current_weather.test_data_methods.CurrentTestDataBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.restassured.response.Response;
import org.junit.Test;

public class PositiveTest extends CoreTestCase {

    @Test
    @Tag("Hard implementation")
    @DisplayName("Current weather request for 4 cities")
    @Description("Current weather request for 4 cities: Moscow, New York, London, Berlin")
    public void testPositive() {
//        for (Object o : Cities.values()) {
//            CurrentWeatherModel actualModel = new CurrentWeatherMethods(Cities.valueOf(o.toString())).sendRequestByCity();
//            CurrentWeatherModel exampleModel = new CurrentWeatherExamplesModel().createMockModel(Cities.valueOf(o.toString()));
//            CurrentWeatherMethods methods = new CurrentWeatherMethods();
//            methods.assertEqualResponseBodies(exampleModel, actualModel);
//        }
    }

    @Test
    public void testSendCurrentRequest() {
        for (Cities cityToTest : Cities.values()) {
            Response response = new RequestToCurrentWeather(cityToTest, true).sendRequestToCurrent();
            CurrentWeatherModel actualResult = CurrentWeatherResponseMethods.parseCorrectBody(response);
            CurrentWeatherModel expectedResult = new CurrentTestDataBuilder(cityToTest).createTestDataModel();
            CurrentWeatherResponseMethods.assertEqualResponseBodies(expectedResult, actualResult);
        }
    }
}
