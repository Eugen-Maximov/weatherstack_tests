package tests;


import API.APIRequest;
import io.restassured.specification.RequestSpecification;
import lib.CoreTestCase;
import lib.methods.ErrorMessageResponseSpec;
import lib.models.current.CurrentWeatherExample;
import lib.models.current.CurrentWeatherMethods;
import lib.models.current.CurrentWeatherModel;
import org.junit.Test;

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
    public void test() {
        RequestSpecification request = APIRequest.request();
        request.get(requestPath).then().spec(ErrorMessageResponseSpec.response()).log().ifError();
//        String json = response.getBody().asString();
//        System.out.println(json);
//        Gson g = new Gson();
//        ErrorMessageModel model = g.fromJson(json, ErrorMessageModel.class);
//        System.out.println(model.success);
//        Message message = model.error;
//        System.out.println(message);
//
//        JsonElement gson = new JsonParser().parse("ErrorMessageModel.json");
//
//        JSONAssert.assertEquals(
//                expectedString,
//                response.getBody().asString(),
//                false
//        );
    }

    @Test
    public void testPositive() throws Exception {
        CurrentWeatherModel actualModel = new CurrentWeatherMethods("New York", true).sendRequestByCity();
        CurrentWeatherModel exampleModel = new CurrentWeatherExample().createMockModel();
        CurrentWeatherMethods methods = new CurrentWeatherMethods();
        System.out.println(actualModel.getRequest().getType());
        System.out.println(actualModel.getRequest().getQuery());
        System.out.println(actualModel.getRequest().getLanguage());
        System.out.println(actualModel.getRequest().getUnit());
        System.out.println(exampleModel.getLocation().getName());
        methods.assertEqualResponseBodies(exampleModel, actualModel);
    }
}
