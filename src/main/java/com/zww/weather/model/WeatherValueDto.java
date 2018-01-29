package com.zww.weather.model;

import java.util.List;

/**
 * Created by zhaoww on 2018/1/26.
 */
public class WeatherValueDto {
    private List<WeatherAlarmDto> alarms;
    private String city;
    private String cityid;
    private List<WeatherIndexDto> indexes;
    private WeatherPm25Dto pm25;
    private String provinceName;
    private WeatherRealtimeDto realtime;
    private WeatherDetailsInfoDto weatherDetailsInfo;
    private List<WeathersDto> weathers;

    public List<WeatherAlarmDto> getAlarms() {
        return alarms;
    }

    public void setAlarms(List<WeatherAlarmDto> alarms) {
        this.alarms = alarms;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public List<WeatherIndexDto> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<WeatherIndexDto> indexes) {
        this.indexes = indexes;
    }

    public WeatherPm25Dto getPm25() {
        return pm25;
    }

    public void setPm25(WeatherPm25Dto pm25) {
        this.pm25 = pm25;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public WeatherRealtimeDto getRealtime() {
        return realtime;
    }

    public void setRealtime(WeatherRealtimeDto realtime) {
        this.realtime = realtime;
    }

    public Object getWeatherDetailsInfo() {
        return weatherDetailsInfo;
    }

    public void setWeatherDetailsInfo(WeatherDetailsInfoDto weatherDetailsInfo) {
        this.weatherDetailsInfo = weatherDetailsInfo;
    }

    public Object getWeathers() {
        return weathers;
    }

    public void setWeathers(List<WeathersDto> weathers) {
        this.weathers = weathers;
    }

    @Override
    public String toString() {
        return "WeatherValueDto{" +
                "alarms=" + alarms +
                ", city='" + city + '\'' +
                ", cityid='" + cityid + '\'' +
                ", indexes=" + indexes +
                ", pm25=" + pm25 +
                ", provinceName='" + provinceName + '\'' +
                ", realtime=" + realtime +
                ", weatherDetailsInfo=" + weatherDetailsInfo +
                ", weathers=" + weathers +
                '}';
    }
}
