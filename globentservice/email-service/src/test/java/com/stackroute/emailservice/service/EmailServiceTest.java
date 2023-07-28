package com.stackroute.emailservice.service;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.stackroute.emailservice.model.EmailTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmailService.class})
@ExtendWith(SpringExtension.class)
class EmailServiceTest {
    @Autowired
    private EmailService emailService;

    @MockBean
    private JavaMailSender javaMailSender;

    @Test
    void testSendEmail() throws MailException {
        doNothing().when(javaMailSender).send((SimpleMailMessage) any());

        EmailTemplate emailTemplate = new EmailTemplate();
        emailTemplate.setBody("Body of the Mail");
        emailTemplate.setSendTo("nikhil.bari@globallogic.com");
        emailTemplate.setSubject("Subject of the Mail");
        emailService.sendEmail(emailTemplate);
        verify(javaMailSender).send((SimpleMailMessage) any());
    }

    @Test
    void testSendEmail2() throws MailException {
        doNothing().when(javaMailSender).send((SimpleMailMessage) any());
        EmailTemplate emailTemplate = mock(EmailTemplate.class);
        when(emailTemplate.getBody()).thenReturn("Body of the mail");
        when(emailTemplate.getSendTo()).thenReturn("nikhil.bari@globallogic.com");
        when(emailTemplate.getSubject()).thenReturn("Subject of the Mail");
        doNothing().when(emailTemplate).setBody((String) any());
        doNothing().when(emailTemplate).setSendTo((String) any());
        doNothing().when(emailTemplate).setSubject((String) any());
        emailTemplate.setBody("Body of the mail");
        emailTemplate.setSendTo("nikhil.bari@globallogic.com");
        emailTemplate.setSubject("Subject of the Mail");
        emailService.sendEmail(emailTemplate);
        verify(javaMailSender).send((SimpleMailMessage) any());
        verify(emailTemplate).getBody();
        verify(emailTemplate).getSendTo();
        verify(emailTemplate).getSubject();
        verify(emailTemplate).setBody((String) any());
        verify(emailTemplate).setSendTo((String) any());
        verify(emailTemplate).setSubject((String) any());
    }
}