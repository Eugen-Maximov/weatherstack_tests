package API;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import lib.CoreTestCase;

public class APIRequest {

    static String baseUri = CoreTestCase.getBaseUri();

    public APIRequest() {}

    public static RequestSpecification request() {
        String authToken = AuthToken.getUserToken();
        return RestAssured
                .given()
                .queryParam("access_key", authToken)
                .baseUri(baseUri);
    }
}
