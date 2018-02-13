package com.zww.weather.service.impl;

import com.zww.weather.model.WeatherResponseDto;
import com.zww.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhaoww on 2018/2/13.
 */
@Service("weatherService")
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponseDto getWeatherDtlInfo(String url) {
        return restTemplate.getForObject(url, WeatherResponseDto.class);
    }
}
