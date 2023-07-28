package com.stackroute.feedbackservice.dto;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateFeedback {
    @NotNull
    private String userName;
    @NotNull
    private int eventId;
    @NotBlank(message = "feedback content can't be empty")
    @Length(min = 3,max = 500)
    private String feedback;
    @NotNull
    @Min(0)
    @Max(5)
    private double rating;

}
