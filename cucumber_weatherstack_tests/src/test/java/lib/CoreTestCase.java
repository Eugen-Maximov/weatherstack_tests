package lib;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class CoreTestCase {

    protected static final String baseURL = "http://api.weatherstack.com";

    @Before
    public void setUp() {
        setURI();
    }

    @After
    public void resetAll() {
        RestAssured.reset();
    }

    protected void setURI() {
        RestAssured.baseURI = baseURL;
    }

    protected void setURI(String url) {
        RestAssured.baseURI = url;
    }
}
