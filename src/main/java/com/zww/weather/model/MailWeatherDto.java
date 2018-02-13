package com.zww.weather.model;

import java.util.List;

/**
 * Created by zhaoww on 2018/2/13.
 */
public class MailWeatherDto {
    private List<EmailDto> email;

    public List<EmailDto> getEmail() {
        return email;
    }

    public void setEmail(List<EmailDto> email) {
        this.email = email;
    }
}
