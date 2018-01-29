package com.zww.weather.model;

/**
 * Created by zhaoww on 2018/1/26.
 */
public class WeatherRealtimeDto {
    private long img;
    private long sD;
    private long sendibleTemp;
    private long temp;
    private String time;
    private String wD;
    private String wS;
    private String weather;
    private String ziwaixian;

    public long getImg() {
        return img;
    }

    public void setImg(long img) {
        this.img = img;
    }

    public long getsD() {
        return sD;
    }

    public void setsD(long sD) {
        this.sD = sD;
    }

    public long getSendibleTemp() {
        return sendibleTemp;
    }

    public void setSendibleTemp(long sendibleTemp) {
        this.sendibleTemp = sendibleTemp;
    }

    public long getTemp() {
        return temp;
    }

    public void setTemp(long temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getwD() {
        return wD;
    }

    public void setwD(String wD) {
        this.wD = wD;
    }

    public String getwS() {
        return wS;
    }

    public void setwS(String wS) {
        this.wS = wS;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getZiwaixian() {
        return ziwaixian;
    }

    public void setZiwaixian(String ziwaixian) {
        this.ziwaixian = ziwaixian;
    }
}
