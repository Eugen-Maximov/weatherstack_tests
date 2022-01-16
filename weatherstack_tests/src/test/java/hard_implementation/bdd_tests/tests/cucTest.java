package hard_implementation.bdd_tests.tests;

import hard_implementation.lib.requests.current_weather.CurrentWeatherModel;
import hard_implementation.lib.requests.current_weather.CurrentWeatherResponseMethods;
import hard_implementation.lib.requests.current_weather.RequestToCurrentWeather;
import hard_implementation.lib.requests.current_weather.current_data.Cities;
import hard_implementation.lib.requests.current_weather.current_data.CurrentExpectedModelBuilder;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Также;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;

public class cucTest {

    Response response;
    CurrentWeatherModel actualResult;
    CurrentWeatherModel expectedResult;

    @Когда("отправить GET запрос на получение погоды по выбранному городу")
    public void отправить_get_запрос_на_получение_погоды_по_выбранному_городу() {
        response = new RequestToCurrentWeather(Cities.NEW_YORK, true).sendRequestToCurrent();
        actualResult = CurrentWeatherResponseMethods.parseCorrectBody(response);
        throw new io.cucumber.java.PendingException();
    }

    @Также("подготовить тестовую модель по выбранному городу")
    public void parseTestModel() {
        expectedResult = new CurrentExpectedModelBuilder(Cities.NEW_YORK).createTestDataModel();
        throw new io.cucumber.java.PendingException();
    }

    @Тогда("обе модели должны быть равны")
    public void compareModels() {
        CurrentWeatherResponseMethods.assertEqualResponseBodies(expectedResult, actualResult);
        throw new io.cucumber.java.PendingException();
    }
}
