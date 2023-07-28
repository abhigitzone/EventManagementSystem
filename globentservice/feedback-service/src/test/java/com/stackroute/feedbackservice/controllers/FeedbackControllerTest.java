package com.stackroute.feedbackservice.controllers;

import com.stackroute.feedbackservice.dto.AddFeedback;
import com.stackroute.feedbackservice.dto.FeedbackDetail;
import com.stackroute.feedbackservice.dto.UpdateFeedback;
import com.stackroute.feedbackservice.exceptions.FeedbackAlreadyExistException;
import com.stackroute.feedbackservice.exceptions.FeedbackNotFoundException;
import com.stackroute.feedbackservice.service.IFeedbackService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FeedbackControllerTest {

    @Mock
    IFeedbackService service;

    @InjectMocks
    @Spy
    FeedbackController controller;


    /**
     *saveFeedback for success
     */
    @Test
    void testAddFeedback_1() throws Exception{
        FeedbackDetail response =mock(FeedbackDetail.class);
        AddFeedback request=mock(AddFeedback.class);
        when(service.addFeedback(request)).thenReturn(response);
        FeedbackDetail result= controller.addFeedback(request).getBody();
        assertEquals(response,result);
        verify(service).addFeedback(request);
    }
    /**
     *save feedback then throw feedback already exist
     */
    @Test
    void testAddFeedback_2()throws Exception {
        FeedbackDetail response =mock(FeedbackDetail.class);
        AddFeedback request=mock(AddFeedback.class);
        when(service.addFeedback(request)).thenThrow(FeedbackAlreadyExistException.class);
        Executable excutable=()->service.addFeedback(request);
        assertThrows(FeedbackAlreadyExistException.class,excutable);

    }
    /**
     * update Feedback
     * for success status
     */

    @Test
    void testUpdateFeedback() throws Exception {
        FeedbackDetail response=mock(FeedbackDetail.class);
        UpdateFeedback request=mock(UpdateFeedback.class);
        when(service.modifyFeedback(request)).thenReturn(response);
        FeedbackDetail result= controller.updateFeedback(request).getBody();
        assertEquals(response,result);
        verify(service).modifyFeedback(request);
    }

    /**
     * update feedback
     * @throws Exception
     */


    @Test
    void testUpdateFeedback_2()throws Exception {
        FeedbackDetail response =mock(FeedbackDetail.class);
        UpdateFeedback request=mock(UpdateFeedback.class);
        when(service.modifyFeedback(request)).thenThrow(FeedbackNotFoundException.class);
        Executable excutable=()->service.modifyFeedback(request);
        assertThrows(FeedbackNotFoundException.class,excutable);

    }
    /**
     * delete feedback by id
     * if id is found
     */

    @Test
        void testDeleteFeedback()throws Exception {
            String userName="jhon";
            String response="deleted successfully";
            when(service.deleteFeedbackByUserName(userName)).thenReturn(response);
            String result=controller.deleteFeedback(userName).getBody();
            assertEquals(response,result);
            verify(service).deleteFeedbackByUserName(userName);

        }

    /**
     * delete feedback
     * @throws Exception
     */

    @Test
    void testDeleteFeedback_2()throws Exception {
        String userName="jhon";
        String response="deleted successfully";
        when(service.deleteFeedbackByUserName(userName)).thenThrow(FeedbackNotFoundException.class);
        Executable excutable=()->service.deleteFeedbackByUserName(userName);
        assertThrows(FeedbackNotFoundException.class,excutable);

    }



}