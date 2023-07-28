package com.stackroute.feedbackservice.service;



import com.stackroute.feedbackservice.dto.AddFeedback;
import com.stackroute.feedbackservice.dto.FeedbackDetail;
import com.stackroute.feedbackservice.dto.UpdateFeedback;
import com.stackroute.feedbackservice.exceptions.FeedbackAlreadyExistException;
import com.stackroute.feedbackservice.exceptions.FeedbackNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated

public interface IFeedbackService {

    FeedbackDetail addFeedback(@Valid AddFeedback requestData)throws FeedbackAlreadyExistException;

    FeedbackDetail modifyFeedback(@Valid UpdateFeedback requestData) throws FeedbackNotFoundException;

    List<FeedbackDetail> fetchAllFeedback();

    FeedbackDetail fetchFeedbackByUserNameAndEventId(String userName,@Min(0) Integer eventId)throws FeedbackNotFoundException;

    List<FeedbackDetail> getFeedbackByEventId(@Min(0)Integer eventId) throws FeedbackNotFoundException;


    String deleteFeedbackByUserName(String userName)throws Exception;





}
