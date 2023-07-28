package com.stackroute.emailservice.service;

import com.stackroute.emailservice.model.EmailTemplate;


public interface IEmailService {
    void sendEmail(EmailTemplate template);
}
