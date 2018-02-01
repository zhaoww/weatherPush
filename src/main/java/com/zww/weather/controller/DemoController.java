package com.zww.weather.controller;

import com.zww.weather.model.EmailDto;
import com.zww.weather.model.WeatherResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhaoww on 2018/1/29.
 */
@Controller
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/index")
    public String index(Model model){

        String url = "http://aider.meizu.com/app/weather/listWeather?cityIds=101190104";
        WeatherResponseDto weatherResponseDto = restTemplate.getForObject(url, WeatherResponseDto.class);
        EmailDto email = new EmailDto();
        email.setWeatherResponseDto(weatherResponseDto);
        model.addAttribute("email",email);
        return "weather";

    }
}
