package lib;


import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

public class CoreTestCase {

    /*
    environment TOKEN = 1ad6d6000b35dffa30ed6e17ec33b366
     */
    
    @Before
    public void setUp() {
        RestAssured.baseURI = "http://api.weatherstack.com";
        //RestAssured.baseURI = System.getenv("URI");
    }

    @After
    public void tearDown() {
        RestAssured.reset();
    }

    @Rule
    public TestName testName = new TestName();
}
