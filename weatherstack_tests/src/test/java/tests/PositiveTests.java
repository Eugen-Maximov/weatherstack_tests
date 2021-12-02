package tests;


import API.APIRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lib.CoreTestCase;
import org.junit.Test;

public class PositiveTests extends CoreTestCase {

    private static final String requestPath = "current";

    @Test
    public void test() {
        RequestSpecification request = APIRequest.request();
        Response response = request.get(requestPath);
        response.getBody().prettyPrint();
    }
}
