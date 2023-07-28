package com.stackroute.participantservice.util;

import com.stackroute.participantservice.dto.ParticipantDetails;
import com.stackroute.participantservice.entity.Participant;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParticipantUtil {
    public ParticipantDetails toParticipantDetails(Participant participant) {
        ParticipantDetails participantsDetails = new ParticipantDetails();
        participantsDetails.setUserName(participant.getUserName());
        participantsDetails.setUserAge(participant.getUserAge());
        participantsDetails.setEvent(participant.getEvent());
        participantsDetails.setParticipantName(participant.getParticipantName());
        participantsDetails.setParticipantID(participant.getParticipantID());
        return participantsDetails;

    }
    public List<ParticipantDetails> toParticipantDetails(Collection<Participant> participants){
        List<ParticipantDetails>list = participants.stream().map(this::toParticipantDetails).collect(Collectors.toList());
        return list;
    }

}
