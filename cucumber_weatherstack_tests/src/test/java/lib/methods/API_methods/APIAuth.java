package lib.methods.API_methods;

import io.cucumber.java.en.Given;
import io.qameta.allure.Step;

public class APIAuth {

    public static String token;

    @Given("get API key for request")
    @Step("Get auth token from system ENV")
    public void getAuthToken() {
        token = System.getenv("TOKEN");
    }
}
