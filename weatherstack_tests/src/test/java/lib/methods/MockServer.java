package lib.methods;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import java.io.IOException;

public class MockServer {

    private  MockWebServer mockWebServer;
    private  MockResponse response;
    private  String mockURL = "http://api.weatherstack.com/current?access_key=1ad6d6000b35dffa30ed6e17ec33b366&query=New%20York";

    public MockServer() {

    }
    public  void startMocking(String mockJson) {
        mockWebServer = new MockWebServer();
        try {
            mockWebServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mockWebServer.url(mockURL);
        mockedResponse(mockJson);
    }

    public  void mockedResponse(String mockJson) {
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
    }
}
