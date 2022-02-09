package lib.methods;

import io.cucumber.java.en.Then;
import lib.data.CitiesExamples;
import lib.data.ErrorsExamples;
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
    public void createExpectedResults(List<String> modelsNames) {
        names = modelsNames;
        createExpectedResultsByClass();
    }

    @Then("^create expected model$")
    @Then("^create expected models$")
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

    private void createCitiesModels() {
        for (String s : names) {
            selectCitiesModel(s);
        }
    }

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
        if (name.contains(space)) {
            name = name.replace(space, underscore);
        }
        switch (CitiesExamples.valueOf(name.toUpperCase(Locale.ROOT))) {
            case NEW_YORK:
                expectedModels.add(ModelParser.parseModel(CitiesExamples.NEW_YORK.getJson(), classToParse));
                break;
            case MOSCOW:
                expectedModels.add(ModelParser.parseModel(CitiesExamples.MOSCOW.getJson(), classToParse));
                break;
            case BERLIN:
                expectedModels.add(ModelParser.parseModel(CitiesExamples.BERLIN.getJson(), classToParse));
                break;
            case LONDON:
                expectedModels.add(ModelParser.parseModel(CitiesExamples.LONDON.getJson(), classToParse));
                break;
            default:
                throw new IllegalArgumentException("Cannot detect city name to create expected model.\n" +
                        "Your city: " + name);
        }
    }
}