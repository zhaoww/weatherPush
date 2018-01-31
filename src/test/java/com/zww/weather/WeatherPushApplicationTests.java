package com.zww.weather;

import com.zww.weather.config.EmailProperties;
import com.zww.weather.model.EmailDto;
import com.zww.weather.model.WeatherResponseDto;
import com.zww.weather.service.MailService;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class WeatherPushApplicationTests extends AbstractCoreBootTests {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MailService mailService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

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
        EmailProperties mail = new EmailProperties();
        mail.setTo(new String[]{"1023181495@qq.com"});
        mail.setContent("标题：测试标题");
        mail.setSubject("测试内容部份");
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
        EmailProperties mailProperties = new EmailProperties();
        mailProperties.setFrom("zhaoweiwei233@163.com");
        mailProperties.setTo(new String[]{"3045675825@qq.com"});
        mailProperties.setContent("标题：测试标题");
        mailProperties.setSubject("测试内容部份");
        mailProperties.setTemplate("weatherTpl");
        EmailDto email = new EmailDto();
        BeanUtils.copyProperties(mailProperties, email);
        email.setWeatherResponseDto(getWeatherDtlInfo());
        mailService.sendThymeleafMail(email);
    }

    private WeatherResponseDto getWeatherDtlInfo(){
        String url = "http://aider.meizu.com/app/weather/listWeather?cityIds=101190104" ;
        return restTemplate.getForObject(url, WeatherResponseDto.class);
    }
}
