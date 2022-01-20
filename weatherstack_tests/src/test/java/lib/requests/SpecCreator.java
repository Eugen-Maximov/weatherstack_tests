package lib.requests;

import API.APIAuth;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class SpecCreator {

    private String queryString;
    private boolean isAuth = false;
    private RequestSpecification requestSpecification = RestAssured.given();
    private RequestSpecification authSpec;
    private RequestSpecification querySpec;

    public SpecCreator(String cityToRequest, boolean isAuth) {
        this.queryString = cityToRequest;
        this.isAuth = isAuth;
    }

    public SpecCreator(String cityToRequest) {
        this.queryString = cityToRequest;
    }

    public SpecCreator(boolean isAuth) {
        this.isAuth = isAuth;
    }

    public SpecCreator() {
    }

    public RequestSpecification getSpecification() {
        getAuthSpec();
        getQuerySpec();
        mergeSpecs();
        return requestSpecification;
    }

    private void getQuerySpec() {
        querySpec = RestAssured
                .given()
                .queryParam("query", queryString);
    }

    private void getAuthSpec() {
        if (isAuth) authSpec = APIAuth.authUser();
    }

    private void mergeSpecs() {
        if (authSpec != null && querySpec != null) {
            requestSpecification = RestAssured
                    .given()
                    .spec(authSpec)
                    .spec(querySpec);
        }
    }
}
