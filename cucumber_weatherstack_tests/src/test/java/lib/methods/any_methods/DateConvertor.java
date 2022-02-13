package lib.methods.any_methods;

import io.qameta.allure.Step;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateConvertor {

    private TimeZone timeZone;

    public DateConvertor(String timeZone) {
        this.timeZone = TimeZone.getTimeZone(timeZone);
    }

    @Step("Get date and time of selected region")
    public String getSimpleDate() {
        Date date = new Date();
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    @Step("Get UNIX time of selected region")
    public long getTimestamp() {
        long timestamp = System.currentTimeMillis() / 1000;
        int offset = (timeZone.getRawOffset()) / 1000;
        return timestamp + offset;
    }
}
