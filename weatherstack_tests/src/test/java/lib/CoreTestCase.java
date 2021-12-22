package lib;


import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;

public class CoreTestCase {

    /*
    environment TOKEN = 1ad6d6000b35dffa30ed6e17ec33b366
     */

    private static final String baseUri = "";

    public static String getBaseUri() {
        return baseUri;
    }
    
    @Before
    public void setUp() {
        RestAssured.baseURI = "http://api.weatherstack.com";
    }

    @After
    public void tearDown() {
        RestAssured.reset();
    }
}
