package com.stackroute.feedbackservice.service;


import com.stackroute.feedbackservice.exceptions.FeedbackAlreadyExistException;
import com.stackroute.feedbackservice.util.FeedbackUtil;
import com.stackroute.feedbackservice.dto.AddFeedback;
import com.stackroute.feedbackservice.dto.FeedbackDetail;
import com.stackroute.feedbackservice.dto.UpdateFeedback;
import com.stackroute.feedbackservice.exceptions.FeedbackNotFoundException;
import com.stackroute.feedbackservice.model.Feedback;
import com.stackroute.feedbackservice.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements IFeedbackService{

    private FeedbackRepository repository;

    private FeedbackUtil util;
    @Autowired
    public FeedbackServiceImpl(FeedbackRepository repository,FeedbackUtil util){
        this.repository=repository;
        this.util=util;
    }
    private int id;
    public int generateId() {
        return ++id;
    }

    @Transactional
    @Override
    public FeedbackDetail addFeedback(AddFeedback requestData)throws FeedbackAlreadyExistException {
        Feedback feedback=new Feedback();
        if(!repository.existsByUserNameAndEventId(requestData.getUserName(),requestData.getEventId())){
            feedback.setId(generateId());
            feedback.setUserName(requestData.getUserName());
            feedback.setEventId(requestData.getEventId());
            feedback.setFeedback(requestData.getFeedback());
            feedback.setRating(requestData.getRating());
            repository.save(feedback);
            return util.toFeedbackDetail(feedback);
        }
            throw new FeedbackAlreadyExistException("feedback already exist for the event : '"+requestData.getUserName()+"'and'"+requestData.getEventId());
    }

    public Feedback findByUserNameAndEventId(String userName,int eventId)  throws FeedbackNotFoundException {
        Optional<Feedback> optional = repository.findByUserNameAndEventId(userName,eventId);
        if(optional.isEmpty()){
            throw new FeedbackNotFoundException(" Feedback not found for the username:'"+userName+"'and eventId '"+eventId+"'please provide proper username and eventId");
        }
        return optional.get();

    }
    public Feedback findByUserName(String userName)  throws FeedbackNotFoundException {
        Optional<Feedback> optional = repository.findByUserName(userName);
        if(optional.isEmpty()){
            throw new FeedbackNotFoundException(" Feedback not found for the username:'"+userName+"'please provide proper username");
        }
        return optional.get();

    }

    @Transactional
    @Override
    public FeedbackDetail modifyFeedback(UpdateFeedback requestData) throws FeedbackNotFoundException {
        Feedback feedback=findByUserNameAndEventId(requestData.getUserName(),requestData.getEventId());
        feedback.setFeedback(requestData.getFeedback());
        feedback.setRating(requestData.getRating());
        repository.save(feedback);
        return  util.toFeedbackDetail(feedback);
    }

    @Transactional(readOnly = true)
    @Override
    public List<FeedbackDetail> fetchAllFeedback() {
        List<Feedback> feedbackList=repository.findAll();
        return util.toFeedbackDetailsList(feedbackList);
    }

    @Transactional(readOnly = true)
    @Override
    public FeedbackDetail fetchFeedbackByUserNameAndEventId(String userName,Integer eventId)throws FeedbackNotFoundException{
        Feedback feedback=findByUserNameAndEventId(userName,eventId);
        if(feedback==null){
            throw new FeedbackNotFoundException("feedback not found for username and eventId:" +userName+"and" +eventId);
        }
        return repository.fetchAllFeedbackByUserNameAndEventId(userName,eventId);

    }

    @Transactional(readOnly = true)
    @Override
    public List<FeedbackDetail> getFeedbackByEventId(Integer eventId) throws FeedbackNotFoundException {
        if(repository.getFeedbacksByEvent(eventId).isEmpty()){
            throw new FeedbackNotFoundException("feedback not found for eventId"+eventId);
        }
        return repository.getFeedbacksByEvent(eventId);
    }

    @Transactional
    @Override
    public String deleteFeedbackByUserName(String userName)throws FeedbackNotFoundException {
        findByUserName(userName);
        repository.deleteByUserName(userName);
        return "deleted successfully";
    }
}
