package com.stackroute.participantservice.entity;

import com.stackroute.participantservice.dto.EventDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("participant_data")
public class Participant {

    @Id
    private int participantID;
    @UniqueElements
    private String participantName;
    private String userName;
    private Integer userAge;
    private  EventDetailsDto event ;
}


