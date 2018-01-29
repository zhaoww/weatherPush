package com.zww.weather.model;

import java.util.List;

/**
 * Created by zhaoww on 2018/1/26.
 */
public class WeatherDetailsInfoDto {
    private String publishTime;
    private List<Weather3HoursDetailsInfosDto> weather3HoursDetailsInfos;

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public List<Weather3HoursDetailsInfosDto> getWeather3HoursDetailsInfos() {
        return weather3HoursDetailsInfos;
    }

    public void setWeather3HoursDetailsInfos(List<Weather3HoursDetailsInfosDto> weather3HoursDetailsInfos) {
        this.weather3HoursDetailsInfos = weather3HoursDetailsInfos;
    }
}
