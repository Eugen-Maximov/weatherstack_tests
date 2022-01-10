package hard_implementation.lib.requests.errors.errors_data;

import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.json.JsonException;
import hard_implementation.lib.requests.errors.ErrorModel;

import java.io.IOException;
import java.nio.file.Paths;

public class ErrorExpectedModelBuilder {

    private static Errors errorCode;
    private static ErrorModel model;

    public ErrorExpectedModelBuilder(Errors errorCode) {
        ErrorExpectedModelBuilder.errorCode = errorCode;
    }

    public ErrorModel getExpectedErrorModel() {
        model = getBasicJsonModel();
        return model;
    }

    private static ErrorModel getBasicJsonModel() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(Paths.get(errorCode.getJson()).toFile(), ErrorModel.class);
        } catch (IOException e) {
            throw new JsonException("Cannot parse test data model from .json file" + e.getMessage());
        }
    }
}
