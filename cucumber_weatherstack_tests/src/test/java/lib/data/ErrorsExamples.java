package lib.data;

import java.io.File;
import java.nio.file.Paths;

public enum ErrorsExamples {

    CODE_101(101, "src/test/resources/error_bodies/101_body.json"), //no auth
    CODE_601(601, "src/test/resources/error_bodies/601_body.json"), //no query
    CODE_103(103, "src/test/resources/error_bodies/103_body.json"), //invalid path
    CODE_615(615, "src/test/resources/error_bodies/615_body.json"); //request failed

    private int code;
    private String path;

    ErrorsExamples(int code, String path) {
        this.code = code;
        this.path = path;
    }

    public int getCode() {
        return code;
    }

    public File getJson() {
        return Paths.get(path).toFile();
    }
}
