package hard_implementation.lib.methods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeConverter {

    private static TimeZone timeZone;

    public static Object[] getTimeAndDateByTimezone(String timezoneName) {
        timeZone = TimeZone.getTimeZone(timezoneName);
        return new Object[]{
                getSimpleDate(),
                getTimestamp()
        };
    }

    private static String getSimpleDate() {
        Date date = new Date();
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    private static long getTimestamp() {
        long timestamp = System.currentTimeMillis() / 1000;
        int offset = (timeZone.getRawOffset()) / 1000;
        return timestamp + offset;
    }
}
