package hard_implementation.lib.requests.errors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.json.JsonException;
import hard_implementation.lib.Comparator;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static hard_implementation.lib.Comparator.equalCompare;
import static hard_implementation.lib.Comparator.statusCodeAssert;

public class ErrorsMethods {

    private static int checkingCode;


    @Step("Parse error response body")
    public static ErrorModel parseErrorBody(Response response) {
        String jsonBody = response.getBody().asString();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonBody, ErrorModel.class);
        } catch (JsonProcessingException error) {
            throw new JsonException("There is not error message json body.\n" + "Your json:\n" + jsonBody);
        }
    }

    @Step("Compare actual response body with expected body")
    public static void assertEqualsErrorBodies(ErrorModel extendsModel, ErrorModel actualModel) {
        checkingCode = extendsModel.getMessage().getCode();
        equalCompare(extendsModel.getSuccess(), actualModel.getSuccess(), checkingCode + "-code: success");
        assertEqualMessage(extendsModel.getMessage(), actualModel.getMessage());
        Comparator.compareAll();
    }

    @Step("Compare 'message' part of error response body")
    private static void assertEqualMessage(ErrorModel.Message extendsMessage, ErrorModel.Message actualMessage) {
        statusCodeAssert(extendsMessage.getCode(), actualMessage.getCode(), checkingCode + "-code: error code");
        equalCompare(extendsMessage.getType(), actualMessage.getType(), checkingCode + "-code: message type)");
        equalCompare(extendsMessage.getInfo(), actualMessage.getInfo(), checkingCode + "-code: message info)");
    }

    public static void checkIsItError(Response response) {
        ErrorModel errorModel = parseErrorBody(response);
        if (errorModel == null) {
            throw new JsonException("Can't recognize json response body.\n" + "Your json:\n" + response.getBody().asString());
        }
    }
}
