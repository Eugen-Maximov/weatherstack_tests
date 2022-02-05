package lib.models;

public enum Models {

    CURRENT ("current", CurrentWeatherModel.class),
    ERROR ("error", CurrentWeatherModel.class);

    private String name;
    private Class modelClass;

    Models(String name, Class modelClass) {
        this.name = name;
        this.modelClass = modelClass;
    }

    public String getName() {
        return name;
    }

    public Class getModelClass() {
        return modelClass;
    }
}
