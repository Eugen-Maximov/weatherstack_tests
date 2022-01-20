package lib.methods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeConverter {

    private TimeZone timeZone;

    public TimeConverter(String timeZone) {
        this.timeZone = TimeZone.getTimeZone(timeZone);
    }

    public TimeConverter() {}

    public String getSimpleDate() {
        Date date = new Date();
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    public long getTimestamp() {
        long timestamp = System.currentTimeMillis() / 1000;
        int offset = (timeZone.getRawOffset()) / 1000;
        return timestamp + offset;
    }
}
