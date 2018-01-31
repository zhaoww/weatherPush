package com.zww.weather.config;

import com.zww.weather.model.WeatherResponseDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by zhaoww on 2018/1/31.
 */
@Component
@ConfigurationProperties(prefix = "email")
@PropertySource(value = "classpath:application.properties")
public class EmailProperties {

    //必填参数
    private  String from;

    private String[] to;//接收方邮件

    private String subject;//主题

    private String content;//邮件内容

    //选填
    private String template;//模板

    private HashMap<String, String> kvMap;// 自定义参数

    private WeatherResponseDto weatherResponseDto;

    public WeatherResponseDto getWeatherResponseDto() {
        return weatherResponseDto;
    }

    public void setWeatherResponseDto(WeatherResponseDto weatherResponseDto) {
        this.weatherResponseDto = weatherResponseDto;
    }
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
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

    public HashMap<String, String> getKvMap() {
        return kvMap;
    }

    public void setKvMap(HashMap<String, String> kvMap) {
        this.kvMap = kvMap;
    }

}
