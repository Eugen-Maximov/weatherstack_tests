package lib.methods;

import io.cucumber.java.en.Given;

public class APIAuth {

    public static String token;

    @Given("get API key for request")
    public void getAuthToken() {
        token = System.getenv("TOKEN");
    }
}
