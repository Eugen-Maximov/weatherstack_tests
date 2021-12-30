package lib.methods;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class APIAuth {

    private static String api_key;

    public APIAuth() {
        api_key = getToken();
    }

    public static RequestSpecification authUser() {
        return RestAssured
                .given()
                .queryParam("access_key", api_key);
    }

    public static String getToken() {
        try {
            return System.getenv("TOKEN");
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
