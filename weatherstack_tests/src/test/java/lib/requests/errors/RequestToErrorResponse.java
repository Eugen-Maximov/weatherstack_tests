package lib.requests.errors;

import lib.requests.GetRequest;
import lib.requests.SpecCreator;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class RequestToErrorResponse {

    private String path;
    private SpecCreator specCreator;

    public RequestToErrorResponse(String path, String query, boolean authToken) {
        this.path = path;
        specCreator = new SpecCreator(query, authToken);
    }

    public RequestToErrorResponse(String path, String query) {
        this.path = path;
        specCreator = new SpecCreator(query);
    }

    public RequestToErrorResponse(String path, boolean authToken) {
        this.path = path;
        specCreator = new SpecCreator(authToken);
    }

    public RequestToErrorResponse(String path) {
        this.path = path;
    }

    @Step("Send request for error response")
    public Response sendRequestToError() {
        GetRequest request = new GetRequest(specCreator.getSpecification());
        return request.sendGetRequest(path);
    }
}
