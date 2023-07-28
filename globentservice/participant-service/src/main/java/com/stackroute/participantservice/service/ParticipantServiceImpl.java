package com.stackroute.participantservice.service;

import com.stackroute.participantservice.dto.AddParticipantDto;
import com.stackroute.participantservice.dto.ParticipantDetails;
import com.stackroute.participantservice.dto.UpdateParticipantDto;
import com.stackroute.participantservice.entity.Participant;
import com.stackroute.participantservice.exception.ParticipantNotFoundException;
import com.stackroute.participantservice.exception.ParticipantAreadyExistException;
import com.stackroute.participantservice.repository.ParticipantRepository;
import com.stackroute.participantservice.util.ParticipantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantServiceImpl implements IParticipantService{

    private ParticipantRepository participantRepository;
    private ParticipantUtil util;

    private int participantID;

    public int generateParticipantID() {
        return ++participantID;
    }
    @Autowired
    public ParticipantServiceImpl(ParticipantRepository participantRepository,ParticipantUtil util){
        this.participantRepository = participantRepository;
        this.util=util;
    }

    @Override
    public ParticipantDetails addParticipant( AddParticipantDto requestData) throws ParticipantAreadyExistException {
        Participant participant = new Participant();
        if (!participantRepository.existsByParticipantName(requestData.getParticipantName())) {
            participant.setParticipantID(generateParticipantID());
            participant.setUserName(requestData.getUserName());
            participant.setUserAge(requestData.getUserAge());
            participant.setParticipantName(requestData.getParticipantName());
            participant.setEvent(requestData.getEvent());
            participantRepository.save(participant);
            return util.toParticipantDetails(participant);
        }


            throw new ParticipantAreadyExistException("Username name already exist:" + requestData.getUserName());
        }



    @Override
    public String deleteParticipantById(@PathVariable Integer participantID) throws ParticipantNotFoundException{
         findById(participantID);




     participantRepository.deleteById(participantID);
     return "deleted successfully";

    }

    @Override
    public ParticipantDetails fetchedParticipantByUserId(Integer id) throws ParticipantNotFoundException {
        Participant participant = findById(id);
        return util.toParticipantDetails(participant);
    }

    @Override
    public List<ParticipantDetails> fetchAllParticipant() {
       List<Participant> participantList = participantRepository.findAll();
        return util.toParticipantDetails(participantList);
    }

    @Override
    public List<Participant> participantByUserName(String userName) throws ParticipantNotFoundException {
        List<Participant> allParticipant = participantRepository.findAll();
        List<Participant> userParticipant = new ArrayList<>();
        for(Participant p:allParticipant){
            try {
                if(p.getUserName().equals(userName)){
                    userParticipant.add(p);

                }
            }catch (NullPointerException e){
                e.getMessage();
            }
        }
        if(userParticipant.isEmpty()){
            throw new ParticipantNotFoundException("participant not found for given username");
        }
        return userParticipant;
    }



    @Override
    public ParticipantDetails updateParticipantNameByUserName(UpdateParticipantDto userName) throws ParticipantNotFoundException {
       Participant participant = findByUserName(userName.getUserName());
        participant.setParticipantName(userName.getParticipantName());
        participant.setUserName(userName.getUserName());
        participant = participantRepository.save(participant);
        return util.toParticipantDetails(participant);
    }

    public Participant findById(Integer id) throws ParticipantNotFoundException {
          Optional<Participant>optional= participantRepository.findById(id);
          if(optional.isEmpty()){
              throw new ParticipantNotFoundException("participant not found for id: "+id) ;
          }
        return optional.get();

      }
      public Participant findByUserName(String userName) throws ParticipantNotFoundException{
        Optional<Participant> participant = participantRepository.findByUserName(userName);
        if(participant.isEmpty()){
            throw new ParticipantNotFoundException("participant for this username not found");
        }
        return participant.get();
      }

}
