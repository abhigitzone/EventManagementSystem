package com.stackroute.feedbackservice.controllers;
import com.stackroute.feedbackservice.dto.AddFeedback;
import com.stackroute.feedbackservice.dto.FeedbackDetail;
import com.stackroute.feedbackservice.dto.UpdateFeedback;
import com.stackroute.feedbackservice.exceptions.FeedbackNotFoundException;
import com.stackroute.feedbackservice.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/feedback/v1")
public class FeedbackController {
    private IFeedbackService service;

    @Autowired
    public FeedbackController(IFeedbackService service) {this.service=service;
    }
    @PostMapping("feedback")
    public  ResponseEntity<FeedbackDetail> addFeedback(@RequestBody AddFeedback requestData)throws Exception {
        return  new ResponseEntity<FeedbackDetail>(service.addFeedback(requestData),HttpStatus.OK);

    }
    @PutMapping("feedback")
    public ResponseEntity<FeedbackDetail> updateFeedback(@RequestBody UpdateFeedback requestData) throws FeedbackNotFoundException {
        return  new ResponseEntity<FeedbackDetail>(service.modifyFeedback(requestData),HttpStatus.OK);
    }
    @GetMapping("feedbacks")
    public List<FeedbackDetail> getAllFeedbacks()  {return service.fetchAllFeedback();}
    @GetMapping("feedback/{userName}/{eventId}")
    public ResponseEntity<FeedbackDetail> getAllFeedbackByUserNameAndEventId( @PathVariable("userName") String userName,@PathVariable("eventId") Integer eventId){
        return new ResponseEntity<FeedbackDetail>(service.fetchFeedbackByUserNameAndEventId(userName,eventId),HttpStatus.OK);
    }

    @GetMapping("feedback/{eventId}")
    public List<FeedbackDetail> getAllFeedbackDetailByEvent(@PathVariable("eventId") Integer eventId){
        return service.getFeedbackByEventId(eventId);
    }
    @DeleteMapping("feedback/{userName}")
    public ResponseEntity<String> deleteFeedback(@PathVariable("userName") String userName) throws Exception {
        String status= service.deleteFeedbackByUserName(userName);
        return new ResponseEntity<String>(status,HttpStatus.OK);
    }



}



