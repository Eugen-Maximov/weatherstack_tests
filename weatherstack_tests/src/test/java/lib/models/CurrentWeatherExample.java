package lib.models;

import java.util.Arrays;

public class CurrentWeatherExample {

    /*
    for example
     */

    public CurrentWeatherModel createExampleModel() {
        CurrentWeatherModel model = new CurrentWeatherModel();
        model.setRequest(createExampleRequest());
        model.setLocation(createExampleLocation());
        model.setCurrent(createExampleCurrent());
        return model;
    }

    private CurrentWeatherModel.Request createExampleRequest() {
        CurrentWeatherModel.Request requestModel = new CurrentWeatherModel.Request();
        requestModel
                .setType("City")
                .setQuery("New York, United States of America")
                .setLanguage("en")
                .setUnit("m");
        return requestModel;
    }

    private CurrentWeatherModel.Location createExampleLocation() {
        CurrentWeatherModel.Location locationModel = new CurrentWeatherModel.Location();
        locationModel
                .setName("New York")
                .setCountry("United States of America")
                .setRegion("New York")
                .setLat("40.714")
                .setLon("-74.006")
                .setTimezoneId("America/New_York")
                .setLocalTime("2019-09-07 08:14")
                .setLocalTimeEpoch(1567844040)
                .setUtcOffset("-4.0");
        return locationModel;
    }

    private CurrentWeatherModel.Current createExampleCurrent() {
        CurrentWeatherModel.Current currentModel = new CurrentWeatherModel.Current();
        currentModel
                .setObservationTime("12:14 PM")
                .setTemperature(13)
                .setWeatherCode(113)
                .setWeatherIcons(Arrays.asList("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0001_sunny.png"))
                .setWeatherDescriptions(Arrays.asList("Sunny"))
                .setWindSpeed(0)
                .setWindDegree(349)
                .setWindDir("N")
                .setPressure(1010)
                .setPrecip(0)
                .setHumidity(90)
                .setCloudCover(0)
                .setFeelsLike(13)
                .setUvIndex(4)
                .setVisibility(16);
        return currentModel;
    }
}
