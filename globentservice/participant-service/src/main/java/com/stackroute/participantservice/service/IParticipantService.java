package com.stackroute.participantservice.service;

import com.stackroute.participantservice.dto.AddParticipantDto;
import com.stackroute.participantservice.dto.ParticipantDetails;
import com.stackroute.participantservice.dto.UpdateParticipantDto;
import com.stackroute.participantservice.entity.Participant;
import com.stackroute.participantservice.exception.ParticipantAreadyExistException;
import com.stackroute.participantservice.exception.ParticipantNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface IParticipantService {

    ParticipantDetails addParticipant(@Valid AddParticipantDto requestData) throws ParticipantAreadyExistException;


    String deleteParticipantById(@Valid Integer participantID)throws ParticipantNotFoundException;

    ParticipantDetails fetchedParticipantByUserId(@Valid Integer userId) throws ParticipantNotFoundException;

    List<ParticipantDetails> fetchAllParticipant();

    List<Participant> participantByUserName(@Valid String userName) throws ParticipantNotFoundException;


    ParticipantDetails updateParticipantNameByUserName(@Valid UpdateParticipantDto userName) throws ParticipantNotFoundException;



}
