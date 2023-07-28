package com.stackroute.participantservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventDetailsDto {
    private int eventId;
    private String eventName;
    private String eventDescription;
    private String eventVenue;
    private LocalDate eventDate;
    private String startTime;
    private String endTime;
    private Double eventAmount;
    private Integer eventCapacity;
    private String userName;
    private String userEmail;

}


