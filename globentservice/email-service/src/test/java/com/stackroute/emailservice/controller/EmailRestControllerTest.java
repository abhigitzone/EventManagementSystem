package com.stackroute.emailservice.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.emailservice.model.EmailTemplate;
import com.stackroute.emailservice.service.IEmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmailRestController.class})
@ExtendWith(SpringExtension.class)
class EmailRestControllerTest {
    @Autowired
    private EmailRestController emailRestController;

    @MockBean
    private IEmailService iEmailService;

    @Test
    void testSendEMail() throws Exception {
        doNothing().when(iEmailService).sendEmail((EmailTemplate) any());

        EmailTemplate emailTemplate = new EmailTemplate();
        emailTemplate.setBody("Body of the mail");
        emailTemplate.setSendTo("nikhil.bari@globallogic.com");
        emailTemplate.setSubject("Subject of the mail");
        String content = (new ObjectMapper()).writeValueAsString(emailTemplate);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/notification/mail")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(emailRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("Email Sent!"));
    }
}