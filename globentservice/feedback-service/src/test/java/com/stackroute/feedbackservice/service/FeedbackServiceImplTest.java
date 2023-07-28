package com.stackroute.feedbackservice.service;



import com.stackroute.feedbackservice.dto.AddFeedback;
import com.stackroute.feedbackservice.dto.FeedbackDetail;
import com.stackroute.feedbackservice.exceptions.FeedbackAlreadyExistException;
import com.stackroute.feedbackservice.exceptions.FeedbackNotFoundException;
import com.stackroute.feedbackservice.model.Feedback;
import com.stackroute.feedbackservice.repository.FeedbackRepository;
import com.stackroute.feedbackservice.util.FeedbackUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FeedbackServiceImplTest {

    @Mock
    FeedbackRepository feedbackRepository;

    @Mock
    FeedbackUtil util;

    @InjectMocks
    @Spy
    FeedbackServiceImpl service;

    /**
     *
     *  FeedbackFound
     *  input userName="jhon"
     *  verifying feedbackRepository.findByUserName(userName) called once
     */
 @Test
  void testFindByUserNameFeedbackFound() throws Exception {
     String userName= "jhon";
     int eventId=1;
     Feedback feedback=mock(Feedback.class);
     Optional<Feedback> optional=Optional.of(feedback);
     when(feedbackRepository.findByUserNameAndEventId(userName,eventId)).thenReturn(optional);
     Feedback result=service.findByUserNameAndEventId(userName,eventId);
     assertEquals(feedback,result);
     verify(feedbackRepository).findByUserNameAndEventId(userName,eventId);
 }
    /**
     *test for findByUserName
       @throws FeedbackNotFoundException
     */
    @Test
     void testFindByUserNameFeedbackNotFound() throws Exception{
        String userName="mik";
        int eventId=1;
        Optional<Feedback> optional=Optional.empty();
        when(feedbackRepository.findByUserNameAndEventId(userName,eventId)).thenReturn(optional);
        Executable executable=()->service.findByUserNameAndEventId(userName,eventId);
        assertThrows(FeedbackNotFoundException.class,executable);
    }
    /**
     * test case for save feedback
     * for success status
     */


        @Test
        void testAddFeedback_1() throws FeedbackAlreadyExistException {
        Feedback feedback = new Feedback();
        feedback.setEventId(123);
        feedback.setFeedback("Feedback");
        feedback.setId(1);
        feedback.setRating(10.0d);
        feedback.setUserName("janedoe");
        when(feedbackRepository.existsByUserNameAndEventId((String) any(), anyInt())).thenReturn(false);
        when(feedbackRepository.save((Feedback) any())).thenReturn(feedback);

        FeedbackDetail feedbackDetail = new FeedbackDetail();
        feedbackDetail.setEventId(123);
        feedbackDetail.setFeedback("Feedback");
        feedbackDetail.setId(1);
        feedbackDetail.setRating(10.0d);
        feedbackDetail.setUserName("janedoe");
        when(util.toFeedbackDetail((Feedback) any())).thenReturn(feedbackDetail);

        AddFeedback addFeedback = new AddFeedback();
        addFeedback.setEventId(123);
        addFeedback.setFeedback("Feedback");
        addFeedback.setRating(10.0d);
        addFeedback.setUserName("janedoe");
        assertSame(feedbackDetail, service.addFeedback(addFeedback));
        verify(feedbackRepository).existsByUserNameAndEventId((String) any(), anyInt());
        verify(feedbackRepository).save((Feedback) any());
        verify(util).toFeedbackDetail((Feedback) any());
    }

    /**
     * testing save feedback
     * @throws FeedbackAlreadyExistException
     */

    @Test
    void testAddFeedback_2() throws FeedbackAlreadyExistException {
        Feedback feedback = new Feedback();
        feedback.setEventId(123);
        feedback.setFeedback("Feedback");
        feedback.setId(1);
        feedback.setRating(10.0d);
        feedback.setUserName("janedoe");
        when(feedbackRepository.existsByUserNameAndEventId((String) any(), anyInt())).thenReturn(true);
        AddFeedback addFeedback = new AddFeedback();
        addFeedback.setEventId(123);
        addFeedback.setFeedback("Feedback");
        addFeedback.setRating(10.0d);
        addFeedback.setUserName("janedoe");
        assertThrows(FeedbackAlreadyExistException.class, () -> service.addFeedback(addFeedback));
        verify(feedbackRepository).existsByUserNameAndEventId((String) any(), anyInt());
    }
    /**
     *test case for delete Feedback
     */
    @Test
    void testDeleteFeedbackByUserName() throws FeedbackNotFoundException {
        Feedback feedback = new Feedback();
        feedback.setEventId(123);
        feedback.setFeedback("Feedback");
        feedback.setId(1);
        feedback.setRating(10.0d);
        feedback.setUserName("janedoe");
        Optional<Feedback> ofResult = Optional.of(feedback);
        doNothing().when(feedbackRepository).deleteByUserName((String) any());
        when(feedbackRepository.findByUserName((String) any())).thenReturn(ofResult);
        assertEquals("deleted successfully", service.deleteFeedbackByUserName("janedoe"));
        verify(feedbackRepository).findByUserName((String) any());
        verify(feedbackRepository).deleteByUserName((String) any());
    }

    /**
     * test for delete Feedback
     * @throws Exception
     */
    @Test
    void testDeleteFeedbackByUserName3() throws FeedbackNotFoundException {
        Feedback feedback = new Feedback();
        feedback.setEventId(123);
        feedback.setFeedback("Feedback");
        feedback.setId(1);
        feedback.setRating(10.0d);
        feedback.setUserName("janedoe");
        Optional<Feedback> ofResult = Optional.of(feedback);
        doThrow(new FeedbackNotFoundException("deleted successfully")).when(feedbackRepository)
                .deleteByUserName((String) any());
        when(feedbackRepository.findByUserName((String) any())).thenReturn(ofResult);
        assertThrows(FeedbackNotFoundException.class, () -> service.deleteFeedbackByUserName("janedoe"));
        verify(feedbackRepository).findByUserName((String) any());
        verify(feedbackRepository).deleteByUserName((String) any());
    }


}