package hard_implementation.lib.requests.current_weather.test_data;

import com.fasterxml.jackson.databind.ObjectMapper;
import hard_implementation.lib.requests.current_weather.current.CurrentWeatherModel;

import java.io.IOException;

public class CurrentExampleBuilder {

    protected static Cities city = Cities.NEW_YORK;

    public CurrentExampleBuilder(Cities cities) {
        CurrentExampleBuilder.city = cities;
    }

    public static CurrentWeatherModel getJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(city.getJsonPath(), CurrentWeatherModel.class);
//        return new CurrentWeatherModel()
//                .setRequest(RequestBuilder.getRequestInfo())
//                .setLocation(LocationBuilder.getCityLocationInfo())
//                .setCurrent(CurrentBuilder.getCurrentInfo());
    }

    public static void main(String[] args) {
        try {
            getJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
