package API;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class APIAuth {

    @Step("Set auth token param")
    public static RequestSpecification authUser() {
        return RestAssured
                .given()
                .queryParam("access_key", getToken());
    }

    private static String getToken() {
        try {
            return System.getenv("TOKEN");
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
