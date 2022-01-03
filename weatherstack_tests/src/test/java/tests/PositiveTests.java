package tests;


import lib.CoreTestCase;
import lib.models.current.CurrentWeatherExamplesModel;
import lib.models.current.CurrentWeatherMethods;
import lib.models.current.CurrentWeatherModel;
import lib.test_data.current_request.cities.Cities;
import org.junit.Test;

public class PositiveTests extends CoreTestCase {

    @Test
    public void testPositive() throws Exception {
        Cities firstTestCity = Cities.NEW_YORK;

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
