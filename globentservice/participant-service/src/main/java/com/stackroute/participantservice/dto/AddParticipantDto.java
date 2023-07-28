package com.stackroute.participantservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Setter
@Getter
public class AddParticipantDto {


    @Length(min = 2 ,max = 20,message = "name should be between 2 and 20")
    @NotBlank(message = "name can,t be blank or empty")
    private String userName;

    @Min(value = 18,message = "age can,t be less then 18")
    private Integer userAge;

    @Length(min = 2 ,max = 20,message = "name should be between 2 and 20")
    @NotBlank(message = "name can,t be blank or empty")
    private String participantName;
    private  EventDetailsDto event ;


}
