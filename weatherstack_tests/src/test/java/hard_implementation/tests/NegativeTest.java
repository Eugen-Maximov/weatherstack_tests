package hard_implementation.tests;

import hard_implementation.lib.requests.current_weather.current_data.Cities;
import hard_implementation.lib.requests.errors.ErrorModel;
import hard_implementation.lib.requests.errors.ErrorsMethods;
import hard_implementation.lib.requests.errors.RequestToErrorResponse;
import hard_implementation.lib.requests.errors.errors_data.ErrorExpectedModelBuilder;
import hard_implementation.lib.requests.errors.errors_data.Errors;
import io.restassured.response.Response;
import org.junit.Test;

public class NegativeTest {

    @Test
    public void testNegative() {
        //first error - 101
        Response response = new RequestToErrorResponse("current", Cities.NEW_YORK.getName(), false).sendRequestToError();
        ErrorModel actualResult = ErrorsMethods.parseErrorBody(response);
        ErrorModel expectedResult = new ErrorExpectedModelBuilder(Errors.CODE_101).getExpectedErrorModel();
        ErrorsMethods.assertEqualsErrorBodies(expectedResult, actualResult);
        //second error - 601
        Response response2 = new RequestToErrorResponse("current", true).sendRequestToError();
        ErrorModel actualResult2 = ErrorsMethods.parseErrorBody(response2);
        ErrorModel expectedResult2 = new ErrorExpectedModelBuilder(Errors.CODE_601).getExpectedErrorModel();
        ErrorsMethods.assertEqualsErrorBodies(expectedResult2, actualResult2);
        //third error - 103
        Response response3 = new RequestToErrorResponse("currentre", Cities.NEW_YORK.getName(), true).sendRequestToError();
        ErrorModel actualResult3 = ErrorsMethods.parseErrorBody(response3);
        ErrorModel expectedResult3 = new ErrorExpectedModelBuilder(Errors.CODE_103).getExpectedErrorModel();
        ErrorsMethods.assertEqualsErrorBodies(expectedResult3, actualResult3);
        //forth error - 615
        Response response4 = new RequestToErrorResponse("current", "qwerty", true).sendRequestToError();
        ErrorModel actualResult4 = ErrorsMethods.parseErrorBody(response4);
        ErrorModel expectedResult4 = new ErrorExpectedModelBuilder(Errors.CODE_615).getExpectedErrorModel();
        ErrorsMethods.assertEqualsErrorBodies(expectedResult4, actualResult4);
    }
}
