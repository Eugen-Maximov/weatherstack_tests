package lib.methods.any_methods;

import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import lib.data.CitiesExamples;
import lib.data.ErrorsExamples;
import lib.methods.API_methods.RequestSpecCreator;
import lib.methods.API_methods.ResponseMethods;
import lib.models.CurrentWeatherModel;
import lib.models.ErrorModel;
import lib.models.ModelParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ExpectedResultCreator {

    private Class classToParse = ResponseMethods.parseClass;
    private List<String> names;
    public static List<Object> expectedModels;


    @Then("^create expected model by$")
    @Then("^create expected models by$")
    @Step("Create expected models by names")
    public void createExpectedResults(List<String> modelsNames) {
        names = modelsNames;
        createExpectedResultsByClass();
    }

    @Then("^create expected model$")
    @Then("^create expected models$")
    @Step("Create expected models")
    public void createExpectedResults() {
        names = RequestSpecCreator.citiesNames;
        createExpectedResultsByClass();
    }

    private void createExpectedResultsByClass() {
        expectedModels = new ArrayList<>();
        if (CurrentWeatherModel.class.equals(classToParse)) {
            createCitiesModels();
        } else if (ErrorModel.class.equals(classToParse)) {
            createErrorsModels();
        } else {
            throw new IllegalArgumentException("Cannot detect type of class with examples");
        }
    }

    @Step("Create expected cities models")
    private void createCitiesModels() {
        for (String s : names) {
            selectCitiesModel(s);
        }
    }

    @Step("Create expected errors models")
    private void createErrorsModels() {
        for (String s : names) {
            selectErrorModel(s);
        }
    }

    private void selectErrorModel(String name) {
        switch (ErrorsExamples.valueOf(name.toUpperCase(Locale.ROOT))) {
            case CODE_101:
                expectedModels.add(ModelParser.parseModel(ErrorsExamples.CODE_101.getJson(), classToParse));
                break;
            case CODE_103:
                expectedModels.add(ModelParser.parseModel(ErrorsExamples.CODE_103.getJson(), classToParse));
                break;
            case CODE_601:
                expectedModels.add(ModelParser.parseModel(ErrorsExamples.CODE_601.getJson(), classToParse));
                break;
            case CODE_615:
                expectedModels.add(ModelParser.parseModel(ErrorsExamples.CODE_615.getJson(), classToParse));
                break;
            default:
                throw new IllegalArgumentException("Cannot detect error code to create expected model.\n" +
                        "Your code: " + name);
        }
    }

    private void selectCitiesModel(String name) {
        String space = " ";
        String underscore = "_";
        CurrentWeatherModel model;
        if (name.contains(space)) {
            name = name.replace(space, underscore);
        }
        switch (CitiesExamples.valueOf(name.toUpperCase(Locale.ROOT))) {
            case NEW_YORK:
                model = (CurrentWeatherModel) ModelParser.parseModel(CitiesExamples.NEW_YORK.getJson(), classToParse);
                setActualDate(model);
                expectedModels.add(model);
                break;
            case MOSCOW:
                model = (CurrentWeatherModel) ModelParser.parseModel(CitiesExamples.MOSCOW.getJson(), classToParse);
                setActualDate(model);
                expectedModels.add(model);
                break;
            case BERLIN:
                model = (CurrentWeatherModel) ModelParser.parseModel(CitiesExamples.BERLIN.getJson(), classToParse);
                setActualDate(model);
                expectedModels.add(model);
                break;
            case LONDON:
                model = (CurrentWeatherModel) ModelParser.parseModel(CitiesExamples.LONDON.getJson(), classToParse);
                setActualDate(model);
                expectedModels.add(model);
                break;
            default:
                throw new IllegalArgumentException("Cannot detect city name to create expected model.\n" +
                        "Your city: " + name);
        }
    }

    @Step("Set current date and time to expected model")
    private CurrentWeatherModel setActualDate(CurrentWeatherModel model) {
        String timeZone = model
                .getLocation()
                .getTimezone_id();
        DateConvertor convertor = new DateConvertor(timeZone);
        model
                .getLocation()
                .setLocaltime(convertor.getSimpleDate());
        model
                .getLocation()
                .setLocaltime_epoch(convertor.getTimestamp());
        return model;
    }
}