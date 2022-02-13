package lib.methods.API_methods;

import io.cucumber.java.en.Given;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

public class RequestMethods {

    private final String requestPath = RequestSpecCreator.requestPath;
    public static List<Response> actualResponses;

    @Given("send GET request")
    @Given("send GET requests")
    @Step("Send GET request")
    public void sendGetRequests() {
        RequestSpecCreator.mergeSpecs();
        List<RequestSpecification> requestSpec = RequestSpecCreator.requestSpecs;
        actualResponses = new ArrayList<>();
        for (RequestSpecification spec : requestSpec) {
            actualResponses.add(
                    sendGet(spec)
            );
        }
    }

    private Response sendGet(RequestSpecification specification) {
        return RestAssured
                .given()
                .spec(specification)
                .get(requestPath);
    }
}
