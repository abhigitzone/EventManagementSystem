package com.stackroute.feedbackservice.repository;


import com.stackroute.feedbackservice.dto.FeedbackDetail;
import com.stackroute.feedbackservice.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback,Integer> {

    @Query("{'userName' :?0,'eventId':?1}")
    FeedbackDetail fetchAllFeedbackByUserNameAndEventId(String userName, Integer eventId);

    @Query("{'eventId' :?0}")
    List<FeedbackDetail> getFeedbacksByEvent(Integer eventId);

    Optional<Feedback> findByUserNameAndEventId(String userName,int eventId);

    void deleteByUserName(String userName);


    boolean existsByUserNameAndEventId(String userName,int eventId);

    Optional<Feedback> findByUserName(String userName);
}
