package API;

import io.restassured.RestAssured;
import lib.CoreTestCase;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import java.io.IOException;

public class MockServer extends CoreTestCase {

    private  MockWebServer mockWebServer;
    private  MockResponse response;
    private  String mockURL;

    public MockServer(String mockURL) {
        this.mockURL = mockURL;
    }

    public  void startMocking(String mockJson) {
        mockWebServer = new MockWebServer();
        try {
            mockWebServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestAssured.baseURI = String.valueOf(mockWebServer.url(mockURL));
        mockedResponse(mockJson);
    }

    private void mockedResponse(String mockJson) {
        response = new MockResponse()
                .setBody(mockJson);
        mockWebServer.enqueue(response);
    }

    public  void stopMocking() {
        try {
            mockWebServer.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDefaultUri();
    }
}
