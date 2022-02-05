package lib.methods;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

public class RequestSpecCreator {

    private static List<RequestSpecification> querySpecs;
    private static RequestSpecification authSpec = RestAssured.given();
    public static String requestPath;
    public static List<RequestSpecification> requestSpecs;

    @Given("^request path is (.+)$")
    public void setRequestPath(String requestPath) {
        RequestSpecCreator.requestPath = requestPath;
    }

    @Given("request city parameter is")
    public void setCityParam(List<String> cityName) {
        querySpecs = new ArrayList<>();
        for (String s : cityName) {
            querySpecs.add(
                    RestAssured
                            .given()
                            .queryParam("query", s)
            );
        }
    }

    @Given("^request auth parameter ia added$")
    public void setAuthParam() {
        authSpec = RestAssured
                .given()
                .queryParam("access_key", APIAuth.token);
    }

    public static void mergeSpecs() {
        requestSpecs = new ArrayList<>();
        if (querySpecs.isEmpty()) querySpecs.add(RestAssured.given());
        for (RequestSpecification spec : querySpecs) {
            requestSpecs.add(
                    new RequestSpecBuilder()
                            .addRequestSpecification(authSpec)
                            .addRequestSpecification(spec)
                            .build()
            );
        }
    }
}
