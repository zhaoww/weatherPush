package com.zww.weather.service;

import com.zww.weather.model.EmailDto;

/**
 * Created by zhaoww on 2018/1/31.
 */

public interface MailService {
    void sendSimpleMail(EmailDto mail);

    void sendThymeleafMail(EmailDto mail);
}
