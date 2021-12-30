package lib.models;

import java.util.List;

public class CurrentWeatherModel {

    public Request request;
    public Location location;
    public Current current;

    public static class Request {
        public String type;
        public String query;
        public String language;
        public String unit;

    }

    public static class Location {
        public String name;
        public String country;
        public String lat;
        public String lon;
        public String timezoneId;
        public String localTime;
        public Number localTimeEpoch;
        public String utcOffset;

        public Location setName(String name) {
            this.name = name;
            return this;
        }
    }

    public static class Current {
        public String observationTime;
        public Number temperature;
        public Number weatherCode;
        public List<String> weatherIcons;
        public List<String> weatherDescriptions;
        public Number windSpeed;
        public Number windDegree;
        public String windDir;
        public Number pressure;
        public Number precip;
        public Number humidity;
        public Number cloudCover;
        public Number feelsLike;
        public Number uvIndex;
        public Number visibility;
    }

    public Request getRequest() {
        return request;
    }

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
