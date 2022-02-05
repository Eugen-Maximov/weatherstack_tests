package lib.methods;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.json.JsonException;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import lib.models.Models;

import java.util.ArrayList;
import java.util.List;


public class ResponseMethods {

    private List<Response> responses;
    private List<String> jsonBodies;
    private int responsesCount;
    private String requestName;
    private Class parseClass;
    public static Object actualResponseBody;
    public static Object expectedResponseBody;

    @Then("^(.+) request get response body after sending GET request$")
    public void processingResponseBody(String requestName) {
        this.requestName = requestName;
        responses = RequestMethods.actualResponses;
        responsesCount = responses.size();
        selectClassToParseModel();
        getJsonStrings();

    }


    private List<Object> parseModels() {
        List<Object> modelsList = new ArrayList<>();
        for (String s : jsonBodies) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                modelsList.add(
                        mapper.readValue(s, parseClass)
                );
            } catch (JsonProcessingException e) {
                throw new JsonException("Cannot parse response body.\nYour body: \n" + s);
            }
        }
        return modelsList;
    }

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
