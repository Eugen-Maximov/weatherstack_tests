package hard_implementation.lib.requests.current_weather.test_data.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hard_implementation.lib.requests.current_weather.current.CurrentWeatherModel;
import hard_implementation.lib.requests.current_weather.test_data.CurrentExampleBuilder;
import hard_implementation.lib.requests.current_weather.test_data.Cities;

import java.io.IOException;

public class RequestBuilder extends CurrentExampleBuilder {

    private static final String path = RequestBody.getJson();
    private static CurrentWeatherModel.Request request;

    public RequestBuilder(Cities cities) {
        super(cities);
    }

    public static CurrentWeatherModel.Request getRequestInfo() {
        request = convertFileToJSON(path);
        setQuery();
        return request;
    }

    private static CurrentWeatherModel.Request convertFileToJSON(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(path, CurrentWeatherModel.Request.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void setQuery() {
        request.setQuery(city.getQuery());
    }
}
