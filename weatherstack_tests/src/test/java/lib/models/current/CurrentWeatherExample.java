package lib.models.current;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import java.io.IOException;
import java.util.Arrays;

public class CurrentWeatherExample {

    /*
    for example
     */

    String example = "{\n" +
            "    \"request\": {\n" +
            "        \"type\": \"Town\",\n" +
            "        \"query\": \"New York, United States of America\",\n" +
            "        \"language\": \"en\",\n" +
            "        \"unit\": \"m\"\n" +
            "    },\n" +
            "    \"location\": {\n" +
            "        \"name\": \"Test\",\n" +
            "        \"country\": \"United States of America\",\n" +
            "        \"region\": \"New York\",\n" +
            "        \"lat\": \"40.714\",\n" +
            "        \"lon\": \"-74.006\",\n" +
            "        \"timezone_id\": \"America/New_York\",\n" +
            "        \"localtime\": \"2022-01-02 08:58\",\n" +
            "        \"localtime_epoch\": 1641113880,\n" +
            "        \"utc_offset\": \"-5.0\"\n" +
            "    },\n" +
            "    \"current\": {\n" +
            "        \"observation_time\": \"01:58 PM\",\n" +
            "        \"temperature\": 11,\n" +
            "        \"weather_code\": 143,\n" +
            "        \"weather_icons\": [\n" +
            "            \"https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0006_mist.png\"\n" +
            "        ],\n" +
            "        \"weather_descriptions\": [\n" +
            "            \"Mist\"\n" +
            "        ],\n" +
            "        \"wind_speed\": 0,\n" +
            "        \"wind_degree\": 0,\n" +
            "        \"wind_dir\": \"N\",\n" +
            "        \"pressure\": 1001,\n" +
            "        \"precip\": 0,\n" +
            "        \"humidity\": 93,\n" +
            "        \"cloudcover\": 100,\n" +
            "        \"feelslike\": 10,\n" +
            "        \"uv_index\": 1,\n" +
            "        \"visibility\": 8,\n" +
            "        \"is_day\": \"yes\"\n" +
            "    }\n" +
            "}";

    public CurrentWeatherModel createMockModel() throws IOException {
        CurrentWeatherModel model;

        MockWebServer webServer = new MockWebServer();
        webServer.url("http://api.weatherstack.com/current?access_key=1ad6d6000b35dffa30ed6e17ec33b366&query=New%20York");
        webServer.enqueue(new MockResponse().setBody(example));
        CurrentWeatherMethods methods = new CurrentWeatherMethods("New York", true);
        //mockServer.mockedResponse(example);
        model = methods.sendRequestByCity();
        webServer.shutdown();
        return model;
    }

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
                .setTimezone_id("America/New_York")
                .setLocaltime("2019-09-07 08:14")
                .setLocaltime_epoch(1567844040)
                .setUtc_offset("-4.0");
        return locationModel;
    }

    private CurrentWeatherModel.Current createExampleCurrent() {
        CurrentWeatherModel.Current currentModel = new CurrentWeatherModel.Current();
        currentModel
                .setObservation_time("12:14 PM")
                .setTemperature(13)
                .setWeather_code(113)
                .setWeather_icons(Arrays.asList("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0001_sunny.png"))
                .setWeather_descriptions(Arrays.asList("Sunny"))
                .setWind_speed(0)
                .setWind_degree(349)
                .setWind_dir("N")
                .setPressure(1010)
                .setPrecip(0)
                .setHumidity(90)
                .setCloudcover(0)
                .setFeelslike(13)
                .setUv_index(4)
                .setVisibility(16)
                .setIs_day("yes");
        return currentModel;
    }
}
