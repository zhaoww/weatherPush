package com.zww.weather.job;

import com.zww.weather.config.EmailProperties;
import com.zww.weather.model.EmailDto;
import com.zww.weather.model.WeatherResponseDto;
import com.zww.weather.service.MailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhaoww on 2018/1/31.
 */
@Component
public class SendMailJob {

    @Autowired
    private MailService mailService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmailProperties emailProperties;

    @Value("cityIds")
    private String cityIds;

    @Scheduled(cron = "0 0 7 * * ?")
    private void sendMail() {
        EmailDto email = new EmailDto();
        BeanUtils.copyProperties(emailProperties, email);
        email.setWeatherResponseDto(getWeatherDtlInfo());
        mailService.sendThymeleafMail(email);
    }

    private WeatherResponseDto getWeatherDtlInfo(){
        String url = "http://aider.meizu.com/app/weather/listWeather?cityIds=" + cityIds;
        return restTemplate.getForObject(url, WeatherResponseDto.class);
    }
}
