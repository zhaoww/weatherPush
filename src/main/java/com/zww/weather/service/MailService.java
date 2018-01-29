package com.zww.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by zhaoww on 2018/1/26.
 */
@Component
public class MailService{

//    @Autowired
    private JavaMailSender mailSender = new JavaMailSenderImpl();

    @Value("${mail.fromMail.addr}")
    private String from;

    public void sendSimpleMail(String[] to, String subject, String content) {

//        mailSender.setHost("smtp.qq.com");
//        mailSender.setPort(465);
//        mailSender.setUsername("zhao.weiwei233@qq.com");
//        mailSender.setPassword("zgibmgbewtomzbffdww"); // 这里要用邀请码，不是你登录邮箱的密码

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("标题：测试标题");
        message.setText("测试内容部份");
        try {
            mailSender.send(message);
//            sender.send(message);
        } catch (Exception e) {
            System.out.printf("发送简单邮件时发生异常"+ e.toString());
        }

    }

    public void sendSimpleMail2(String[] to, String subject, String content) {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();

        sender.setHost("smtp.qq.com");
        sender.setPort(465);
        sender.setUsername("zhao.weiwei233@qq.com");
        sender.setPassword("zgibmgbewtomzbffdww"); // 这里要用邀请码，不是你登录邮箱的密码
//
//        Properties pro = System.getProperties(); // 下面各项缺一不可
//        pro.put("mail.smtp.auth", "true");
//        pro.put("mail.smtp.ssl.enable", "true");
//        pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            sender.send(message);
        } catch (Exception e) {
            System.out.printf("发送简单邮件时发生异常"+ e.toString());
        }

    }

    public void sendSimpleMail3(String[] to, String subject, String content) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("主题：HTML邮件");

            StringBuffer sb = new StringBuffer();
            sb.append("<h1>大标题-h1</h1>")
                    .append("<p style='color:#F00'>红色字</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            helper.setText(sb.toString(), true);

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }


}
