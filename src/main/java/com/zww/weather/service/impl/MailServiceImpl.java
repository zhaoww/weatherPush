package com.zww.weather.service.impl;

import com.zww.weather.model.EmailDto;
import com.zww.weather.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by zhaoww on 2018/1/26.
 */
@Service
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Override
    public void sendSimpleMail(EmailDto mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getFrom());
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        mailSender.send(message);
    }

    @Override
    public void sendThymeleafMail(EmailDto mail){
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
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
