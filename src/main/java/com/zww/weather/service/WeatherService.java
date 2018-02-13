package com.zww.weather.service;

import com.zww.weather.model.WeatherResponseDto;

/**
 * Created by zhaoww on 2018/2/13.
 */
public interface WeatherService {

    WeatherResponseDto getWeatherDtlInfo(String url);
}
