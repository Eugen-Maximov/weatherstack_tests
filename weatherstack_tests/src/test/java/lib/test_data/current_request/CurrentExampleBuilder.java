package lib.test_data.current_request;

import lib.models.current.CurrentWeatherModel;
import lib.test_data.current_request.cities.Cities;
import lib.test_data.current_request.cities.LocationBuilder;
import lib.test_data.current_request.current.CurrentBuilder;
import lib.test_data.current_request.request.RequestBuilder;

public class CurrentExampleBuilder {

    protected static Cities city;

    public CurrentExampleBuilder(Cities cities) {
        CurrentExampleBuilder.city = cities;
    }

    public CurrentWeatherModel getJson() {
        return new CurrentWeatherModel()
                .setRequest(RequestBuilder.getRequestInfo())
                .setLocation(LocationBuilder.getCityLocationInfo())
                .setCurrent(CurrentBuilder.getCurrentInfo());
    }
}
