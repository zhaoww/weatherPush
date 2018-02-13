package com.zww.weather.service;

import com.zww.weather.model.EmailDto;

import java.util.Map;

/**
 * Created by zhaoww on 2018/1/31.
 */

public interface MailService {
    Map<String,String> sendSimpleMail(EmailDto mail);

    Map<String,String> sendThymeleafMail(EmailDto mail);

}
