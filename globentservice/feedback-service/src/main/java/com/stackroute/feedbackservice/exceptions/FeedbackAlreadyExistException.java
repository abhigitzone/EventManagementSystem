package com.stackroute.feedbackservice.exceptions;

public class FeedbackAlreadyExistException extends Exception{
    public FeedbackAlreadyExistException(String msg){
        super(msg);
    }
}
