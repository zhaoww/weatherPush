package com.zww.weather;

import com.zww.weather.model.EmailDto;
import com.zww.weather.model.WeatherResponseDto;
import com.zww.weather.service.MailService;
import com.zww.weather.service.WeatherService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.client.RestTemplate;

public class MailServiceTests extends AbstractCoreBootTests {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MailService mailService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private WeatherService weatherService;

    @Value("${spring.mail.username}")
    private String username;

    @Test
    public void getOneInfo() {
        String url = "http://v3.wufazhuce.com:8000/api/onelist/idlist/?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";
        Object o = restTemplate.getForObject(url, Object.class);
        System.out.print(o.toString());
    }

    @Test
    public void testGetWeather(){
        String url = "http://aider.meizu.com/app/weather/listWeather?cityIds=101190104";
        WeatherResponseDto o = restTemplate.getForObject(url, WeatherResponseDto.class);
        System.out.print(o.toString());
    }

    @Test
    public void testSendEmail(){
        EmailDto mail = new EmailDto();
        mail.setTo("1023181495@qq.com");
        mail.setContent("标题：测试标题");
        mail.setSubject("测试内容部份");
        mail.setCityId("101020100");
//        mailService.sendSimpleMail(mail);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("zhaoweiwei233@163.com");
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        mailSender.send(message);
    }

    @Test
    public void testSendThymeleafMail(){
        EmailDto mail = new EmailDto();
        mail.setTo("1023181495@qq.com");
        mail.setContent("今日天气情况");
        mail.setSubject("测试内容部份");
        mail.setCityId("101020100");
        mail.setFrom("zhaoweiwei233@163.com");
        mail.setTemplate("weather");

        mail.setWeatherResponseDto(getWeatherDtlInfo());
        mailService.sendThymeleafMail(mail);
    }

    private WeatherResponseDto getWeatherDtlInfo(){
        String url = "http://aider.meizu.com/app/weather/listWeather?cityIds=101190104" ;
        return weatherService.getWeatherDtlInfo(url);
    }
}
