package API;

public class AuthToken {

    public static String getUserToken() {
        try {
            return System.getenv("TOKEN");
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
