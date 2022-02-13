package lib.methods.API_methods;

import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lib.models.ModelParser;
import lib.models.Models;

import java.util.ArrayList;
import java.util.List;


public class ResponseMethods {

    private List<Response> responses;
    private List<String> jsonBodies;
    private String requestName;
    public static Class parseClass;
    public static List<Object> actualResponses;


    @Then("^(.+) request get response body after sending GET request$")
    @Step("Processing response bodies by type: '{requestName}'")
    public void processingResponseBody(String requestName) {
        this.requestName = requestName;
        responses = RequestMethods.actualResponses;
        selectClassToParseModel();
        getJsonStrings();
        parseModels();
    }

    @Step("Parse response bodies to POJO")
    private void parseModels() {
        actualResponses = ModelParser.parseModel(jsonBodies, parseClass);
    }

    @Step("Select class to parse by type")
    private void selectClassToParseModel() {
        String name = requestName.toUpperCase();
        switch (Models.valueOf(name)) {
            case CURRENT:
                parseClass = Models.CURRENT.getModelClass();
                break;
            case ERROR:
                parseClass = Models.ERROR.getModelClass();
                break;
            default:
                throw new NullPointerException("Cannot detect class to parse model.\n" +
                        "Your class name is: " + name);
        }
    }

    private void getJsonStrings() {
        for (Response r: responses) {
            jsonBodies = new ArrayList<>();
            jsonBodies.add(r.getBody().asString());
        }
    }
}
