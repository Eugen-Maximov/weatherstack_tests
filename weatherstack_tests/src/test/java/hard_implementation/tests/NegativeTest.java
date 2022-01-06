package hard_implementation.tests;

import hard_implementation.lib.requests.current_weather.RequestToCurrentWeather;
import hard_implementation.lib.requests.current_weather.current_data.Cities;
import hard_implementation.lib.requests.errors.ErrorModel;
import hard_implementation.lib.requests.errors.ErrorsMethods;
import hard_implementation.lib.requests.errors.errors_data.ErrorExpectedModelBuilder;
import hard_implementation.lib.requests.errors.errors_data.Errors;
import io.restassured.response.Response;
import org.junit.Test;

public class NegativeTest {

    @Test
    public void testNegative() {
        Errors errorToTest = Errors.CODE_101;
        Response response = new RequestToCurrentWeather(Cities.NEW_YORK).sendRequestToCurrent();
        ErrorModel actualResult = ErrorsMethods.parseErrorBody(response);
        ErrorModel expectedResult = new ErrorExpectedModelBuilder(errorToTest).getExpectedErrorModel();
        ErrorsMethods.assertEqualsErrorBodies(expectedResult, actualResult);
    }
}
