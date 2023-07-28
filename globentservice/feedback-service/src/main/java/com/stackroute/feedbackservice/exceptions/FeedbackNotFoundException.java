package com.stackroute.feedbackservice.exceptions;

public class FeedbackNotFoundException extends RuntimeException{
    public FeedbackNotFoundException(String msg){
        super(msg);
    }
}
