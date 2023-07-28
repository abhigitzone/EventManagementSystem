package com.stackroute.feedbackservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackDetail{
    private int id;
    private Integer eventId;
    private String userName;
    private String feedback;
    private double rating;

}
