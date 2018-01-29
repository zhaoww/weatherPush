package com.zww.weather.model;

import java.util.Date;

/**
 * Created by zhaoww on 2018/1/26.
 */
public class WeatherAlarmDto {
    private String alarmContent;
    private String alarmDesc;
    private String alarmId;
    private long alarmLevelNo;
    private String alarmLevelNoDesc;
    private long alarmType;
    private String alarmTypeDesc;
    private String precaution;
    private String publishTime;

    public String getAlarmContent() {
        return alarmContent;
    }

    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent;
    }

    public String getAlarmDesc() {
        return alarmDesc;
    }

    public void setAlarmDesc(String alarmDesc) {
        this.alarmDesc = alarmDesc;
    }

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }

    public long getAlarmLevelNo() {
        return alarmLevelNo;
    }

    public void setAlarmLevelNo(long alarmLevelNo) {
        this.alarmLevelNo = alarmLevelNo;
    }

    public String getAlarmLevelNoDesc() {
        return alarmLevelNoDesc;
    }

    public void setAlarmLevelNoDesc(String alarmLevelNoDesc) {
        this.alarmLevelNoDesc = alarmLevelNoDesc;
    }

    public long getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(long alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmTypeDesc() {
        return alarmTypeDesc;
    }

    public void setAlarmTypeDesc(String alarmTypeDesc) {
        this.alarmTypeDesc = alarmTypeDesc;
    }

    public String getPrecaution() {
        return precaution;
    }

    public void setPrecaution(String precaution) {
        this.precaution = precaution;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
}
