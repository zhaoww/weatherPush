package com.zww.weather.model;

/**
 * Created by zhaoww on 2018/1/31.
 */
public class EmailDto {
    //必填参数
    private  String from;

    private String to;//接收方邮件

    private String subject;//主题

    private String content;//邮件内容

    //选填
    private String template;//模板

    private String cityId;

    private WeatherResponseDto weatherResponseDto;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public WeatherResponseDto getWeatherResponseDto() {
        return weatherResponseDto;
    }

    public void setWeatherResponseDto(WeatherResponseDto weatherResponseDto) {
        this.weatherResponseDto = weatherResponseDto;
    }
}