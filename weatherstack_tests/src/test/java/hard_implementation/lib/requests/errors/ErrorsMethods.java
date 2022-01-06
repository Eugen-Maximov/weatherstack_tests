package hard_implementation.lib.requests.errors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.json.JsonException;

public class ErrorsMethods {

    public static ErrorModel createErrorModel(String jsonBody) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonBody, ErrorModel.class);
        } catch (JsonProcessingException error) {
            throw new JsonException("There is not error message json body.\n" + "Your json:\n" + jsonBody);
        }
    }

    public static void checkIsItError(String json) {
        ErrorModel errorModel = createErrorModel(json);
        if (errorModel == null) {
            throw new JsonException("Can't recognize json response body.\n" + "Your json:\n" + json);
        }
    }
}
