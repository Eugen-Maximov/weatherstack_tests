package lib.test_data.current_request.cities.cities_bodies;

public class BerlinBody {

    private static final String json =
            "{\n" +
                    "  \"name\": \"Berlin\",\n" +
                    "  \"country\": \"Germany\",\n" +
                    "  \"region\": \"Berlin\",\n" +
                    "  \"lat\": \"52.517\",\n" +
                    "  \"lon\": \"13.400\",\n" +
                    "  \"timezone_id\": \"Europe/Berlin\",\n" +
                    "  \"localtime\": \"{LOCAL_TIME}}\",\n" +
                    "  \"localtime_epoch\": 123456,\n" +
                    "  \"utc_offset\": \"1.0\"\n" +
                    "}";

    private BerlinBody() {}

    public static String getJson() {
        return json;
    }
}
