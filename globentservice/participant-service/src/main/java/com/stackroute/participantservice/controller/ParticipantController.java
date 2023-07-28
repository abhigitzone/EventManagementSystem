package com.stackroute.participantservice.controller;

import com.stackroute.participantservice.dto.AddParticipantDto;
import com.stackroute.participantservice.dto.ParticipantDetails;
import com.stackroute.participantservice.dto.UpdateParticipantDto;
import com.stackroute.participantservice.entity.Participant;
import com.stackroute.participantservice.exception.ParticipantAreadyExistException;
import com.stackroute.participantservice.exception.ParticipantNotFoundException;
import com.stackroute.participantservice.service.IParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/participant/v1")
@RestController
public class ParticipantController {
    private IParticipantService service;


    @Autowired
    public ParticipantController(IParticipantService service) {
        this.service = service;
    }

    @PostMapping("/participant")
    public ResponseEntity<ParticipantDetails> addParticipant(@RequestBody AddParticipantDto requestData) throws ParticipantAreadyExistException {
        return new ResponseEntity<>(service.addParticipant(requestData), HttpStatus.CREATED);
    }


    @DeleteMapping("/participant/{participantID}")
    public ResponseEntity<String> deleteParticipantById(@PathVariable Integer participantID) throws ParticipantNotFoundException {
       return new ResponseEntity<>(service.deleteParticipantById(participantID),HttpStatus.OK) ;

    }

    @GetMapping("/participant/{participantID}")
    public ResponseEntity<ParticipantDetails> fetchedParticipantByUserId(@PathVariable Integer participantID) throws ParticipantNotFoundException {
        return new ResponseEntity<>(service.fetchedParticipantByUserId(participantID), HttpStatus.ACCEPTED);

    }

    @GetMapping("/participants")
    public List<ParticipantDetails> getAllParticipant() {
        return service.fetchAllParticipant();
    }
    @GetMapping("/participant/{userName}")
    public ResponseEntity<List<Participant>> participantByUserName(@PathVariable String userName) throws ParticipantNotFoundException {
        return new ResponseEntity<>(service.participantByUserName(userName),HttpStatus.OK);
    }
    @PatchMapping("/Participant/{userName}")
    public ResponseEntity<ParticipantDetails> updateParticipantByUserName(@RequestBody UpdateParticipantDto userName) throws ParticipantNotFoundException {
        return new ResponseEntity<>(service.updateParticipantNameByUserName(userName),HttpStatus.OK);
    }
}
