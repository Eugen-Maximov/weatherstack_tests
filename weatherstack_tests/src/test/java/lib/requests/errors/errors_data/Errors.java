package lib.requests.errors.errors_data;

public enum Errors {

    CODE_101 (101, "src/test/java/test_data/error_bodies/101_body.json"), //no auth
    CODE_601 (601, "src/test/java/test_data/error_bodies/601_body.json"), //no query
    CODE_103 (103, "src/test/java/test_data/error_bodies/103_body.json"), //invalid path
    CODE_615 (615, "src/test/java/test_data/error_bodies/615_body.json"); //request failed

    private int code;
    private String jsonPath;

    Errors(int code, String jsonPath) {
        this.code = code;
        this.jsonPath = jsonPath;
    }

    public int getCode() {
        return code;
    }

    public String getJson() {
        return jsonPath;
    }
}
