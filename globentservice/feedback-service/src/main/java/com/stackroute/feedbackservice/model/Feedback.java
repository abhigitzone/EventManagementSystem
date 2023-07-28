package com.stackroute.feedbackservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "feedback_data")
public class Feedback {

    @Id
    private int id;
    @NotBlank
    private String userName;
    @NotNull
    private Integer eventId;
    @NotBlank
    @Length(min = 3,max = 500,message = "feedback should between 3 to 500 ")
    private String feedback;
    @Max(5)
    private double rating;






}
