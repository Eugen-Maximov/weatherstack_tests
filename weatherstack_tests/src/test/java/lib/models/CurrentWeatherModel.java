package lib.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherModel {

    public Request request;
    public Location location;
    public Current current;

    public static class Request {
        private String type;
        private String query;
        private String language;
        private String unit;

        //setters
        public Request setType(String type) {
            this.type = type;
            return this;
        }

        public Request setQuery(String query) {
            this.query = query;
            return this;
        }

        public Request setLanguage(String language) {
            this.language = language;
            return this;
        }

        public Request setUnit(String unit) {
            this.unit = unit;
            return this;
        }

        //getters
        public String getType() {
            return type;
        }

        public String getQuery() {
            return query;
        }

        public String getLanguage() {
            return language;
        }

        public String getUnit() {
            return unit;
        }
    }

    public static class Location {
        private String name;
        private String country;
        private String region;
        private String lat;
        private String lon;
        private String timezoneId;
        private String localTime;
        private Number localTimeEpoch;
        private String utcOffset;

        //setters
        public Location setName(String name) {
            this.name = name;
            return this;
        }

        public Location setCountry(String country) {
            this.country = country;
            return this;
        }

        public Location setRegion(String region) {
            this.region = region;
            return this;
        }

        public Location setLat(String lat) {
            this.lat = lat;
            return this;
        }

        public Location setLon(String lon) {
            this.lon = lon;
            return this;
        }

        public Location setTimezoneId(String timezoneId) {
            this.timezoneId = timezoneId;
            return this;
        }

        public Location setLocalTime(String localTime) {
            this.localTime = localTime;
            return this;
        }

        public Location setLocalTimeEpoch(Number localTimeEpoch) {
            this.localTimeEpoch = localTimeEpoch;
            return this;
        }

        public Location setUtcOffset(String utcOffset) {
            this.utcOffset = utcOffset;
            return this;
        }

        //getters
        public String getName() {
            return name;
        }

        public String getCountry() {
            return country;
        }

        public String getRegion() {
            return region;
        }

        public String getLat() {
            return lat;
        }

        public String getLon() {
            return lon;
        }

        public String getTimezoneId() {
            return timezoneId;
        }

        public String getLocalTime() {
            return localTime;
        }

        public Number getLocalTimeEpoch() {
            return localTimeEpoch;
        }

        public String getUtcOffset() {
            return utcOffset;
        }
    }

    public static class Current {
        private String observationTime;
        private Number temperature;
        private Number weatherCode;
        private List<String> weatherIcons;
        private List<String> weatherDescriptions;
        private Number windSpeed;
        private Number windDegree;
        private String windDir;
        private Number pressure;
        private Number precip;
        private Number humidity;
        private Number cloudCover;
        private Number feelsLike;
        private Number uvIndex;
        private Number visibility;

        //setters
        public Current setObservationTime(String observationTime) {
            this.observationTime = observationTime;
            return this;
        }

        public Current setTemperature(Number temperature) {
            this.temperature = temperature;
            return this;
        }

        public Current setWeatherCode(Number weatherCode) {
            this.weatherCode = weatherCode;
            return this;
        }

        public Current setWeatherIcons(List<String> weatherIcons) {
            this.weatherIcons = weatherIcons;
            return this;
        }

        public Current setWeatherDescriptions(List<String> weatherDescriptions) {
            this.weatherDescriptions = weatherDescriptions;
            return this;
        }

        public Current setWindSpeed(Number windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public Current setWindDegree(Number windDegree) {
            this.windDegree = windDegree;
            return this;
        }

        public Current setWindDir(String windDir) {
            this.windDir = windDir;
            return this;
        }

        public Current setPressure(Number pressure) {
            this.pressure = pressure;
            return this;
        }

        public Current setPrecip(Number precip) {
            this.precip = precip;
            return this;
        }

        public Current setHumidity(Number humidity) {
            this.humidity = humidity;
            return this;
        }

        public Current setCloudCover(Number cloudCover) {
            this.cloudCover = cloudCover;
            return this;
        }

        public Current setFeelsLike(Number feelsLike) {
            this.feelsLike = feelsLike;
            return this;
        }

        public Current setUvIndex(Number uvIndex) {
            this.uvIndex = uvIndex;
            return this;
        }

        public Current setVisibility(Number visibility) {
            this.visibility = visibility;
            return this;
        }

        //getters

        public String getObservationTime() {
            return observationTime;
        }

        public Number getTemperature() {
            return temperature;
        }

        public Number getWeatherCode() {
            return weatherCode;
        }

        public List<String> getWeatherIcons() {
            return weatherIcons;
        }

        public List<String> getWeatherDescriptions() {
            return weatherDescriptions;
        }

        public Number getWindSpeed() {
            return windSpeed;
        }

        public Number getWindDegree() {
            return windDegree;
        }

        public String getWindDir() {
            return windDir;
        }

        public Number getPressure() {
            return pressure;
        }

        public Number getPrecip() {
            return precip;
        }

        public Number getHumidity() {
            return humidity;
        }

        public Number getCloudCover() {
            return cloudCover;
        }

        public Number getFeelsLike() {
            return feelsLike;
        }

        public Number getUvIndex() {
            return uvIndex;
        }

        public Number getVisibility() {
            return visibility;
        }
    }

    //getters
    public Request getRequest() {
        return request;
    }

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    //setters
    public void setLocation(Location location) {
        this.location = location;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}