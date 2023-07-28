package com.stackroute.feedbackservice.util;


import com.stackroute.feedbackservice.dto.FeedbackDetail;
import com.stackroute.feedbackservice.model.Feedback;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FeedbackUtil {
    public FeedbackDetail toFeedbackDetail(Feedback feedback){
        FeedbackDetail desired=new FeedbackDetail();
        desired.setId(feedback.getId());
        desired.setUserName(feedback.getUserName());
        desired.setEventId(feedback.getEventId());
        desired.setFeedback(feedback.getFeedback());
        desired.setRating(feedback.getRating());
        return desired;
    }
    public List<FeedbackDetail> toFeedbackDetailsList(Collection<Feedback> products){
        List<FeedbackDetail>list=  products.stream()
                .map(this::toFeedbackDetail)
                .collect(Collectors.toList());
        return list;
    }

}
