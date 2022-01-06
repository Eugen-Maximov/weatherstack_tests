package hard_implementation.lib.requests.current_weather.current;

import hard_implementation.API.MockServer;
import hard_implementation.lib.requests.current_weather.test_data.Cities;
import io.qameta.allure.Step;

public class CurrentWeatherExamplesModel extends CurrentWeatherMethods {

    @Step("Creating test data for the city and replacing the response body")
    public CurrentWeatherModel createMockModel(Cities city) {
        CurrentWeatherModel model;
        MockServer server = new MockServer("/" + getRequestPath());
        server.startMocking(getStringExampleJson(city));
        CurrentWeatherMethods methods = new CurrentWeatherMethods(city);
        model = methods.sendRequestByCity();
        server.stopMocking();
        return model;
    }

    private String getStringExampleJson(Cities city) {
//        CurrentExampleBuilder builder = new CurrentExampleBuilder(city);
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            return mapper.writeValueAsString(builder.getJson());
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return null;
//        }
        return null;
    }
}
