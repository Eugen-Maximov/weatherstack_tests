package lib.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.json.JsonException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelParser {

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Object> parseModel(List<String> jsonBodies, Class classToParse) {
        List<Object> results = new ArrayList<>();
        for (String s : jsonBodies) {
            try {
                results.add(
                        createObject(s, classToParse)
                );
            } catch (JsonProcessingException e) {
                throw new JsonException("Cannot parse response body.\nYour body: \n" + s
                        + "\n\n" + e.getMessage());
            }
        }
        return results;
    }

    public static Object parseModel(String jsonBody, Class classToParse) {
        try {
            return createObject(jsonBody, classToParse);
        } catch (JsonProcessingException e) {
            throw new JsonException("Cannot parse response body.\nYour body: \n" + jsonBody
                    + "\n\n" + e.getMessage());
        }
    }

    public static Object parseModel(File file, Class classToParse) {
        try {
            return createObject(file, classToParse);
        } catch (IOException e) {
            throw new JsonException("Cannot parse response body.\nYour body: \n" + file
                    + "\n\n" + e.getMessage());
        }
    }

    private static Object createObject(String jsonText, Class classToParse) throws JsonProcessingException {
        return mapper.readValue(jsonText, classToParse);
    }

    private static Object createObject(File file, Class classToParse) throws IOException {
        return mapper.readValue(file, classToParse);
    }
}
