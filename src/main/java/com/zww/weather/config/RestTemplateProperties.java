package com.zww.weather.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoww on 2018/1/26.
 */
@Component
@ConfigurationProperties(prefix = "rest")
@PropertySource(value = "classpath:application.properties")
public class RestTemplateProperties {
    /**
     * readtimeout
     */
    private int readtimeout;

    /**
     * connecttimeout
     */
    private int connecttimeout;

    public int getConnecttimeout() {
        return connecttimeout;
    }

    public void setConnecttimeout(int connecttimeout) {
        this.connecttimeout = connecttimeout;
    }

    public int getReadtimeout() {
        return readtimeout;
    }

    public void setReadtimeout(int readtimeout) {
        this.readtimeout = readtimeout;
    }
}
