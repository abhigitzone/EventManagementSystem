package com.stackroute.participantservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParticipantDetails {
    private int participantID;
    private String participantName;
    private String userName;
    private Integer userAge;
    private  EventDetailsDto event ;

}
