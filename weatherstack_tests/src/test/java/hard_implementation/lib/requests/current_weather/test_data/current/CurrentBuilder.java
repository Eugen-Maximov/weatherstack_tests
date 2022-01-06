package hard_implementation.lib.requests.current_weather.test_data.current;

import com.fasterxml.jackson.databind.ObjectMapper;
import hard_implementation.lib.requests.current_weather.current.CurrentWeatherModel;
import hard_implementation.lib.requests.current_weather.test_data.CurrentExampleBuilder;
import hard_implementation.lib.requests.current_weather.test_data.Cities;

import java.io.IOException;

public class CurrentBuilder extends CurrentExampleBuilder {

    private static CurrentWeatherModel.Current current;
    private static final String path = CurrentBody.getJson();

    public CurrentBuilder(Cities cities) {
        super(cities);
    }

    public static CurrentWeatherModel.Current getCurrentInfo() {
        current = convertFileToJSON(path);
        return current;
    }

    private static CurrentWeatherModel.Current convertFileToJSON(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(path, CurrentWeatherModel.Current.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
