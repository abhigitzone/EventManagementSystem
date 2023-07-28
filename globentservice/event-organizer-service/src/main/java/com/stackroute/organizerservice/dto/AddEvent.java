package com.stackroute.organizerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEvent {

    @NotEmpty(message = "event name cant be empty or null :")
    private String eventName;
    private String eventDescription;

    @NotEmpty(message = "event venue can't be null or empty ")
    private String eventVenue;

    private LocalDate eventDate;
    private String startTime;
    private String endTime;

    @Min(value = 1,message = "event amount cant be less than 1 : ")
    private Double eventAmount;
    private Integer eventCapacity;

    @NotEmpty(message = "user name cannot be blank :")
    private String userName;

    @NotEmpty(message = "user email cannot be empty :")
    private String userEmail;

}
