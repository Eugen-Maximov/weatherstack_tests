package lib.models;

import java.util.List;

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
        private String timezone_id;
        private String localtime;
        private Long localtime_epoch;
        private String utc_offset;


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

        public Location setTimezone_id(String timezone_id) {
            this.timezone_id = timezone_id;
            return this;
        }

        public Location setLocaltime(String localtime) {
            this.localtime = localtime;
            return this;
        }

        public Location setLocaltime_epoch(Long localtime_epoch) {
            this.localtime_epoch = localtime_epoch;
            return this;
        }

        public Location setUtc_offset(String utc_offset) {
            this.utc_offset = utc_offset;
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

        public String getTimezone_id() {
            return timezone_id;
        }

        public String getLocaltime() {
            return localtime;
        }

        public Number getLocaltime_epoch() {
            return localtime_epoch;
        }

        public String getUtc_offset() {
            return utc_offset;
        }
    }

    public static class Current {
        private String observation_time;
        private Number temperature;
        private Number weather_code;
        private List<String> weather_icons;
        private List<String> weather_descriptions;
        private Number wind_speed;
        private Number wind_degree;
        private String wind_dir;
        private Number pressure;
        private Number precip;
        private Number humidity;
        private Number cloudcover;
        private Number feelslike;
        private Number uv_index;
        private Number visibility;
        private String is_day;


        //setters
        public Current setObservation_time(String observation_time) {
            this.observation_time = observation_time;
            return this;
        }

        public Current setTemperature(Number temperature) {
            this.temperature = temperature;
            return this;
        }

        public Current setWeather_code(Number weather_code) {
            this.weather_code = weather_code;
            return this;
        }

        public Current setWeather_icons(List<String> weather_icons) {
            this.weather_icons = weather_icons;
            return this;
        }

        public Current setWeather_descriptions(List<String> weather_descriptions) {
            this.weather_descriptions = weather_descriptions;
            return this;
        }

        public Current setWind_speed(Number wind_speed) {
            this.wind_speed = wind_speed;
            return this;
        }

        public Current setWind_degree(Number wind_degree) {
            this.wind_degree = wind_degree;
            return this;
        }

        public Current setWind_dir(String wind_dir) {
            this.wind_dir = wind_dir;
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

        public Current setCloudcover(Number cloudcover) {
            this.cloudcover = cloudcover;
            return this;
        }

        public Current setFeelslike(Number feelslike) {
            this.feelslike = feelslike;
            return this;
        }

        public Current setUv_index(Number uv_index) {
            this.uv_index = uv_index;
            return this;
        }

        public Current setVisibility(Number visibility) {
            this.visibility = visibility;
            return this;
        }

        public void setIs_day(String is_day) {
            this.is_day = is_day;
        }

        //getters

        public String getObservation_time() {
            return observation_time;
        }

        public Number getTemperature() {
            return temperature;
        }

        public Number getWeather_code() {
            return weather_code;
        }

        public List<String> getWeather_icons() {
            return weather_icons;
        }

        public List<String> getWeather_descriptions() {
            return weather_descriptions;
        }

        public Number getWind_speed() {
            return wind_speed;
        }

        public Number getWind_degree() {
            return wind_degree;
        }

        public String getWind_dir() {
            return wind_dir;
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

        public Number getCloudcover() {
            return cloudcover;
        }

        public Number getFeelslike() {
            return feelslike;
        }

        public Number getUv_index() {
            return uv_index;
        }

        public Number getVisibility() {
            return visibility;
        }

        public String getIs_day() {
            return is_day;
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
    public CurrentWeatherModel setLocation(Location location) {
        this.location = location;
        return this;
    }

    public CurrentWeatherModel setRequest(Request request) {
        this.request = request;
        return this;
    }

    public CurrentWeatherModel setCurrent(Current current) {
        this.current = current;
        return this;
    }
}
