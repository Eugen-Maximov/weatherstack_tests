package API;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class APIRequest {

    public APIRequest() {}

    public static RequestSpecification request() {
        String authToken = AuthToken.getUserToken();
        return RestAssured
                .given()
                .queryParam("access_key", authToken);
    }
}
