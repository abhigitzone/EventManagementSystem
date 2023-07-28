package com.stackroute.participantservice.repository;

import com.stackroute.participantservice.entity.Participant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends MongoRepository<Participant,Integer> {
    Optional<Participant> findByUserName(String userName);

    boolean existsByParticipantName(String participantName);

}
