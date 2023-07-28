package com.stackroute.feedbackservice.dto;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
@Setter
public class AddFeedback {
    @NotNull
    private Integer eventId;
    @NotNull

    private String userName;
    @NotBlank(message = "feedback content can't be empty")
    @Length(min = 3,max = 500)
    private String feedback;
    @NotNull
    @Max(5)
    private double rating;


}
