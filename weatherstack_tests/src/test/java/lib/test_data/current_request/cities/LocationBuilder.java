package lib.test_data.current_request.cities;

import com.fasterxml.jackson.databind.ObjectMapper;
import lib.methods.TimeConverter;
import lib.models.current.CurrentWeatherModel;
import lib.test_data.current_request.CurrentExampleBuilder;

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
