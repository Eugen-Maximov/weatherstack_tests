package lib.test_data.current_request.current;

import com.fasterxml.jackson.databind.ObjectMapper;
import lib.models.current.CurrentWeatherModel;
import lib.test_data.current_request.CurrentExampleBuilder;
import lib.test_data.current_request.cities.Cities;

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
