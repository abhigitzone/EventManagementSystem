package com.stackroute.emailservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDetails {
    private int eventId;

    private String eventName;


    private String eventDescription;


    private String eventVenue;


    private Object eventDate;

    private String startTime;

    private String endTime;

    private Double eventAmount;

    private Integer eventCapacity;

    private String userName;

    private String userEmail;

}
