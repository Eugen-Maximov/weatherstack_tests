package hard_implementation.tests;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import hard_implementation.lib.CoreTestCase;
import hard_implementation.lib.requests.current_weather.current.CurrentWeatherExamplesModel;
import hard_implementation.lib.requests.current_weather.current.CurrentWeatherMethods;
import hard_implementation.lib.requests.current_weather.current.CurrentWeatherModel;
import hard_implementation.lib.requests.current_weather.test_data.Cities;
import org.junit.Test;

public class PositiveTest extends CoreTestCase {

    @Test
    @Tag("Hard implementation")
    @DisplayName("Current weather request for 4 cities")
    @Description("Current weather request for 4 cities: Moscow, New York, London, Berlin")
    public void testPositive() throws Exception {
        for (Object o : Cities.values()) {
            CurrentWeatherModel actualModel = new CurrentWeatherMethods(Cities.valueOf(o.toString()))
                    .sendRequestByCity();
            CurrentWeatherModel exampleModel = new CurrentWeatherExamplesModel()
                    .createMockModel(Cities.valueOf(o.toString()));
            CurrentWeatherMethods methods = new CurrentWeatherMethods();
            methods.assertEqualResponseBodies(exampleModel, actualModel);
        }
    }
}
