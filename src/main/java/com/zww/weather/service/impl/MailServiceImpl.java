package com.zww.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zww.weather.model.EmailDto;
import com.zww.weather.model.MailWeatherDto;
import com.zww.weather.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoww on 2018/1/26.
 */
@Service("mailService")
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Override
    public Map<String,String>  sendSimpleMail(EmailDto mail) {
        Map<String,String> map = new HashMap<String,String>();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getFrom());
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        mailSender.send(message);
        map.put("FALG","SUCC");
        return map;
    }

    @Override
    public Map<String,String> sendThymeleafMail(EmailDto mail){
        Map<String,String> map = new HashMap<String,String>();

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            Context context = new Context();
            context.setVariable("email", mail);
            String text = templateEngine.process(mail.getTemplate(), context);
            helper.setText(text, true);
            mailSender.send(message);
            map.put("FALG","SUCC");
        } catch (MessagingException e) {
            map.put("FALG","FAIL");
            e.printStackTrace();
        }finally {
            return map;
        }
    }

}
