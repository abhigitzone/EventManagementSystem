package com.stackroute.organizerservice.repository;

import com.stackroute.organizerservice.document.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends MongoRepository<Event, Integer> {

}
