package lib.methods.API_methods;

import io.cucumber.java.en.Given;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

public class RequestSpecCreator {

    private static List<RequestSpecification> querySpecs;
    private static RequestSpecification authSpec;
    public static String requestPath;
    public static List<RequestSpecification> requestSpecs;
    public static List<String> citiesNames;

    @Given("^request path is (.+)$")
    @Step("Set request path: '{requestPath}'")
    public void setRequestPath(String requestPath) {
        RequestSpecCreator.requestPath = requestPath;
    }

    @Given("request city parameter is")
    @Step("Set query param")
    public void setCityParam(List<String> cityName) {
        citiesNames = new ArrayList<>(cityName);
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
    @Step("Set auth query param to request")
    public void setAuthParam() {
        authSpec = RestAssured
                .given()
                .queryParam("access_key", APIAuth.token);
    }

    public static void mergeSpecs() {
        requestSpecs = new ArrayList<>();
        if (querySpecs == null) {
            querySpecs = new ArrayList<>();
            querySpecs.add(RestAssured.given());
        }
        for (RequestSpecification spec : querySpecs) {
            requestSpecs.add(
                    new RequestSpecBuilder()
                            .addRequestSpecification(authSpec)
                            .addRequestSpecification(spec)
                            .build()
            );
        }
        authSpec = RestAssured.given(); //костыль, чтобы очищать спеку авторизации
    }
}
