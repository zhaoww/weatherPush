package com.zww.weather.model;

import java.util.List;

/**
 * Created by zhaoww on 2018/1/26.
 */
public class WeatherResponseDto {
    private int code;
    private String message;
    private String redirect;
    private List<WeatherValueDto> value;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public List<WeatherValueDto> getValue() {
        return value;
    }

    public void setValue(List<WeatherValueDto> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "WeatherResponseDto{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", redirect='" + redirect + '\'' +
                ", value=" + value +
                '}';
    }
}
