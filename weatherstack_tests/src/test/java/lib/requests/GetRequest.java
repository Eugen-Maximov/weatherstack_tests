package hard_implementation.lib.requests;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

    private RequestSpecification specification;

    public GetRequest(RequestSpecification specification) {
        this.specification = specification;
    }

    @Step("Send get request to '{requestPath}'")
    public Response sendGetRequest(String requestPath) {
        return RestAssured
                .given()
                .spec(specification)
                .get(requestPath);
    }
}
