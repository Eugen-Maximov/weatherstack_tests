package tests;


import API.APIRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lib.CoreTestCase;
import lib.models.ErrorMessageModel;
import lib.models.Message;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.sql.SQLOutput;
import java.util.Arrays;

public class PositiveTests extends CoreTestCase {

    private static final String requestPath = "current";

    String expectedString = "{\n" +
            "  \"success\": \"false\",\n" +
            "  \"error\": {\n" +
            "    \"code\": 104,\n" +
            "    \"type\": \"usage_limit_reached\",\n" +
            "    \"info\": \"Your monthly API request volume has been reached. Please upgrade your plan.\"\n" +
            "  }\n" +
            "}";

    @Test
    public void test() throws JSONException {
        RequestSpecification request = APIRequest.request();
        Response response = request.get(requestPath);
        String json = response.getBody().asString();
        System.out.println(json);
        Gson g = new Gson();
        ErrorMessageModel model = g.fromJson(json, ErrorMessageModel.class);
        System.out.println(model.success);
        Message message = model.error;
        System.out.println(message);

        JsonElement gson = new JsonParser().parse("ErrorMessageModel.json");

        JSONAssert.assertEquals(
                expectedString,
                response.getBody().asString(),
                false
        );
    }
}
