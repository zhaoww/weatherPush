package com.zww.weather.model;

/**
 * Created by zhaoww on 2018/1/26.
 */
public class WeathersDto {
    private String date;
    private long img;
    private String sun_down_time;
    private String sun_rise_time;
    private String temp_day_c;
    private String temp_day_f;
    private String temp_night_c;
    private String temp_night_;
    private String wd;
    private String weather;
    private String week;
    private String ws;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getImg() {
        return img;
    }

    public void setImg(long img) {
        this.img = img;
    }

    public String getSun_down_time() {
        return sun_down_time;
    }

    public void setSun_down_time(String sun_down_time) {
        this.sun_down_time = sun_down_time;
    }

    public String getSun_rise_time() {
        return sun_rise_time;
    }

    public void setSun_rise_time(String sun_rise_time) {
        this.sun_rise_time = sun_rise_time;
    }

    public String getTemp_day_c() {
        return temp_day_c;
    }

    public void setTemp_day_c(String temp_day_c) {
        this.temp_day_c = temp_day_c;
    }

    public String getTemp_day_f() {
        return temp_day_f;
    }

    public void setTemp_day_f(String temp_day_f) {
        this.temp_day_f = temp_day_f;
    }

    public String getTemp_night_c() {
        return temp_night_c;
    }

    public void setTemp_night_c(String temp_night_c) {
        this.temp_night_c = temp_night_c;
    }

    public String getTemp_night_() {
        return temp_night_;
    }

    public void setTemp_night_(String temp_night_) {
        this.temp_night_ = temp_night_;
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

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWs() {
        return ws;
    }

    public void setWs(String ws) {
        this.ws = ws;
    }
}
