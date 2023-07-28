package com.stackroute.emailservice.service;


import com.stackroute.emailservice.model.EmailTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService{
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(EmailTemplate template){


        SimpleMailMessage msg=new SimpleMailMessage();
        try{
            msg.setTo(template.getSendTo());
            msg.setSubject(template.getSubject());
            msg.setText(template.getBody());
            javaMailSender.send(msg);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
