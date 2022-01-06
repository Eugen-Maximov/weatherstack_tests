package hard_implementation.lib.requests.current_weather;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestCurrentWeather {

    private static final String REQUEST_PATH = "current";

    public Response sendRequestToCurrent(RequestSpecification specification) {
        return RestAssured
                .given()
                .spec(specification)
                .get(REQUEST_PATH);
    }


    protected static String getRequestPath() {
        return REQUEST_PATH;
    }
}
