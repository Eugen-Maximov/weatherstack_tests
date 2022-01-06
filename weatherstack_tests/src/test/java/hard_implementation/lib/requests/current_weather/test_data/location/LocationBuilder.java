package hard_implementation.lib.requests.current_weather.test_data.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import hard_implementation.lib.methods.TimeConverter;
import hard_implementation.lib.requests.current_weather.current.CurrentWeatherModel;
import hard_implementation.lib.requests.current_weather.test_data.Cities;
import hard_implementation.lib.requests.current_weather.test_data.CurrentExampleBuilder;

import java.io.IOException;

public class LocationBuilder extends CurrentExampleBuilder {

    protected static CurrentWeatherModel.Location location;

    public LocationBuilder() {
        super(city);
    }

    public static CurrentWeatherModel.Location getCityLocationInfo() {
        location = selectCity(city);
        setDateAndTime();
        return location;
    }

    private static CurrentWeatherModel.Location selectCity(Cities cities) {
        return convertFileToJSON(city.getLocationJson());
    }


    private static CurrentWeatherModel.Location convertFileToJSON(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(fileName, CurrentWeatherModel.Location.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void setDateAndTime() {
        Object[] dateAndTime = TimeConverter.getTimeAndDateByTimezone(location.getTimezone_id());
        location.setLocaltime(dateAndTime[0].toString());
        location.setLocaltime_epoch((long) dateAndTime[1]);
    }
}
