package com.zww.weather.model;

/**
 * Created by zhaoww on 2018/1/26.
 */
public class Weather3HoursDetailsInfosDto {
    private String endTime;
    private long highestTemperature;
    private long img;
    private String isRainFall;
    private long lowerestTemperature;
    private long precipitation;
    private String startTime;
    private String wd;
    private String weather;
    private String ws;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public long getHighestTemperature() {
        return highestTemperature;
    }

    public void setHighestTemperature(long highestTemperature) {
        this.highestTemperature = highestTemperature;
    }

    public long getImg() {
        return img;
    }

    public void setImg(long img) {
        this.img = img;
    }

    public String getIsRainFall() {
        return isRainFall;
    }

    public void setIsRainFall(String isRainFall) {
        this.isRainFall = isRainFall;
    }

    public long getLowerestTemperature() {
        return lowerestTemperature;
    }

    public void setLowerestTemperature(long lowerestTemperature) {
        this.lowerestTemperature = lowerestTemperature;
    }

    public long getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(long precipitation) {
        this.precipitation = precipitation;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWs() {
        return ws;
    }

    public void setWs(String ws) {
        this.ws = ws;
    }
}
