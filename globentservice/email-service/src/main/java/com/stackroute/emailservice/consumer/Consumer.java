package com.stackroute.emailservice.consumer;

import com.stackroute.emailservice.model.EmailTemplate;
import com.stackroute.emailservice.model.EventDetails;
import com.stackroute.emailservice.model.PaymentDetails;
import com.stackroute.emailservice.service.IEmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Consumer {

    IEmailService service;
    @Autowired
    public Consumer(IEmailService service)
    {
        this.service=service;
    }


    @RabbitListener(queues = MQConfig.QUEUE2)
    public void Eventlistener(EventDetails eventDetails) {
        EmailTemplate template = new EmailTemplate();

        template.setSubject("Congratulations, Your " +eventDetails.getEventName() + " event has registered Successfully.");
        template.setSendTo(eventDetails.getUserEmail());
        template.setBody("Hello "+eventDetails.getUserName()+"\n"+"Your event has been successfully registered with following details "+eventDetails.getEventName()
                +". \nWe are Looking forward to provide you with best service \n\n"+
                "Event Id: "+eventDetails.getEventId()+
                "\nEvent Name: "+eventDetails.getEventName()+
                "\nEvent Description: "+eventDetails.getEventDescription()+
                "\nEvent Venue: "+eventDetails.getEventVenue()+
                "\nEvent Date: "+eventDetails.getEventDate()+
                "\nEvent Start Time: "+eventDetails.getStartTime()+
                "\nEvent End Time: "+eventDetails.getEndTime()+
                "\nEvent Capacity: "+eventDetails.getEventCapacity()+
                "\nEvent Amount: "+eventDetails.getEventAmount()+
                "\n\nWe hope this mail find you helpful    \n\n\n\n"+
                "Thanks and Regards  \n"+
                "Globent Service"
                );
        service.sendEmail(template);
    }

    @RabbitListener(queues = MQConfigPayment.QUEUE)
    public void Paymentlistener(PaymentDetails details) {
        EmailTemplate template = new EmailTemplate();
        template.setSubject("Thank You for the Payment of Rs. "+details.getAmount());
        template.setSendTo(details.getUserEmailID());
        template.setBody("Hello sir/mam\nPlease Note that Payment has been Received for participant id: "+details.getParticipantID()+
                " of Amount Rs: "+details.getAmount()+
                "\nwith payment Id of receiver: "+details.getRazorpayOrderId()+
                "\nwith status: "+details.getStatus()+" \n\n We hope you will enjoy our event."+
                "\n\n\n\nThanks and Regards \nGlobent Service"
        );
        service.sendEmail(template);
    }

}
