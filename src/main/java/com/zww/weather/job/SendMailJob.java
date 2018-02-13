package com.zww.weather.job;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zww.weather.model.EmailDto;
import com.zww.weather.model.MailWeatherDto;
import com.zww.weather.service.MailService;
import com.zww.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Created by zhaoww on 2018/1/31.
 */
@Component
public class SendMailJob {

    @Autowired
    private MailService mailService;

    @Autowired
    private WeatherService weatherService;

    @Value(value="classpath:email.json")
    private Resource resource;

    @Scheduled(cron = "0 0 7 * * ?")
    private void sendMail() {
        MailWeatherDto mailWeatherDto= readEmailConfig();
        // 也可以一次调用全部查出来再根据cityid进行过滤 那样最好
        if(mailWeatherDto.getEmail()!=null && mailWeatherDto.getEmail().size() > 0){
            for (EmailDto mailDto: mailWeatherDto.getEmail()){
                String url = "http://aider.meizu.com/app/weather/listWeather?cityIds=" + mailDto.getCityId();
                mailDto.setWeatherResponseDto(weatherService.getWeatherDtlInfo(url));
                mailService.sendThymeleafMail(mailDto);
            }
        }
    }

    private MailWeatherDto readEmailConfig() {
        MailWeatherDto emailWeatherDto = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            StringBuffer message = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                message.append(line);
            }
            String result = message.toString().replace("\r\n", "").replaceAll(" +", "").replaceAll(" ","");
            ObjectMapper objectMapper = new ObjectMapper();
            emailWeatherDto = objectMapper.readValue(result,MailWeatherDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return emailWeatherDto;
        }
    }
}
