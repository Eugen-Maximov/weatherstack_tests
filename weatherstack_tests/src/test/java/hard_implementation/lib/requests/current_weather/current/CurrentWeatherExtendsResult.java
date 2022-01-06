package hard_implementation.lib.requests.current_weather.current;

import hard_implementation.lib.requests.current_weather.RequestToCurrentWeather;

public class CurrentWeatherExtendsResult extends RequestToCurrentWeather {

    /*
    Закомментил тк смысла в подмене ответов нет
     */

//    private static CurrentWeatherModel model;
//    private static ObjectMapper mapper;
//    private static Cities city = getCity();
//
//    @Step("Creating test data for the city and replacing the response body")
//    public CurrentWeatherModel createMockModel(Cities city) {
//        MockServer server = new MockServer("/" + getRequestPath());
//        server.startMocking();
//
//
//        server.stopMocking();
//        return model;
//    }
//
//    private String getStringExampleJson(Cities city) {
//        CurrentExampleBuilder builder = new CurrentExampleBuilder(city);
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            return mapper.writeValueAsString(builder.getJson());
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
