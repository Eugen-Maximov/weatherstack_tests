package hard_implementation.lib.requests.current_weather.test_data.location.location_bodies;

import java.io.File;

public class NewYorkBody {

    private static final String json =
            "{\n" +
                    "  \"name\": \"New York\",\n" +
                    "  \"country\": \"United States of America\",\n" +
                    "  \"region\": \"New York\",\n" +
                    "  \"lat\": \"40.714\",\n" +
                    "  \"lon\": \"-74.006\",\n" +
                    "  \"timezone_id\": \"America/New_York\",\n" +
                    "  \"localtime\": \"{LOCAL_TIME}}\",\n" +
                    "  \"localtime_epoch\": 12345,\n" +
                    "  \"utc_offset\": \"-5.0\"\n" +
                    "}";

    private static final String jsonPath = "test_data\\new_york_body.json";

    private NewYorkBody() {}

    public static String getJson() {
        return json;
    }

    public static File getJsonPath() {
        File file = new File(jsonPath);
        String s = file.getAbsolutePath();
        return new File(s);



        //return jsonPath;
    }
}
