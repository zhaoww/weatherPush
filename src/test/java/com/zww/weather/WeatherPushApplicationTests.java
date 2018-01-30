package com.zww.weather;

import com.zww.weather.model.WeatherResponseDto;
import com.zww.weather.service.MailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.client.RestTemplate;

public class WeatherPushApplicationTests extends AbstractCoreBootTests {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MailService mailService;

    @Autowired
    private JavaMailSender javaMailSender;

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
        String url = "http://aider.meizu.com/app/weather/listWeather?cityIds=101190101";
        WeatherResponseDto o = restTemplate.getForObject(url, WeatherResponseDto.class);
        System.out.print(o.toString());
    }

    @Test
    public void testSendEmail(){
        String[] to = new String[]{"3045675825@qq.com"};
        String subject = "标题：测试标题";
        String content = "测试内容部份";
        mailService.sendSimpleMail(to,subject,content);
    }
}
