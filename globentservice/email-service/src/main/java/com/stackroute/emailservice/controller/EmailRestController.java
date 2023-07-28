package com.stackroute.emailservice.controller;


import com.stackroute.emailservice.model.EmailTemplate;
import com.stackroute.emailservice.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")

public class EmailRestController {

    @Autowired
    private IEmailService emailService;

    @PostMapping(value = "/mail", consumes = "application/json", produces = "application/json")
    public String sendEMail(@RequestBody EmailTemplate emailTemplate){
        try {

            emailService.sendEmail(emailTemplate);
            return "Email Sent!";
        } catch (Exception ex) {
            return "Error in sending email: " + ex;
        }
    }


}
