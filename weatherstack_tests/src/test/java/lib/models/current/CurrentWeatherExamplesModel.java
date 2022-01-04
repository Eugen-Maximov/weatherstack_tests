package lib.models.current;

import API.MockServer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import lib.test_data.current_request.CurrentExampleBuilder;
import lib.test_data.current_request.cities.Cities;

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
        CurrentExampleBuilder builder = new CurrentExampleBuilder(city);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(builder.getJson());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
