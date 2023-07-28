package com.stackroute.participantservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
@Setter
@Getter
public class UpdateParticipantDto {

    @Length(min = 2 ,max = 20,message = "name should be between 2 and 20")
    @NotBlank(message = "name can,t be blank or empty")
    private String participantName;
    @Length(min = 2 ,max = 20,message = "name should be between 2 and 20")
    @NotBlank(message = "name can,t be blank or empty")
    private String userName;


}
