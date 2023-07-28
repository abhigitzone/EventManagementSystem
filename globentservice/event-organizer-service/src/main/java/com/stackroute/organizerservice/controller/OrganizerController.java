package com.stackroute.organizerservice.controller;


import com.stackroute.organizerservice.document.Event;
import com.stackroute.organizerservice.dto.AddEvent;
import com.stackroute.organizerservice.dto.EventDetails;
import com.stackroute.organizerservice.dto.UpdateEvent;
import com.stackroute.organizerservice.exception.EventNotFoundException;
import com.stackroute.organizerservice.exception.InvalidArgumentException;
import com.stackroute.organizerservice.producer.MQConfig;
import com.stackroute.organizerservice.service.OrganizerServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class OrganizerController {

    @Autowired
    private OrganizerServiceImpl service;
    @Autowired
    private RabbitTemplate template;


    @PostMapping("/event/add")
    public EventDetails addEvent(@RequestBody @Valid AddEvent eventDetails) {
        EventDetails response = service.addEventDetails(eventDetails);
        template.convertAndSend(MQConfig.EXCHANGE1, MQConfig.ROUTING_KEY1, response);
        return response;
    }

    @GetMapping("/event")
    public ResponseEntity<List<EventDetails>> allEvents() throws EventNotFoundException {
        try {
            return new ResponseEntity<>(service.eventsList(), HttpStatus.OK);
        } catch (EventNotFoundException e) {
            throw new EventNotFoundException("No Events Found :");
        }
    }

    @GetMapping("/events/id/{id}")
    public ResponseEntity<Event> findById(@PathVariable Integer id) throws EventNotFoundException {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (EventNotFoundException e) {
            throw new EventNotFoundException("Event Not found for the id : " + id);
        }
    }

    @GetMapping("/event/name/{name}")
    public ResponseEntity<EventDetails> eventDetailsByUserName(@PathVariable String name) throws Exception {
        try {
            return new ResponseEntity<>(service.eventByUserName(name), HttpStatus.OK);
        } catch (EventNotFoundException | InvalidArgumentException e) {
            throw new Exception(e.getMessage());
        }
    }


    @PutMapping("/event/{id}")
    public ResponseEntity<EventDetails> updateEvent(@PathVariable Integer id, @RequestBody UpdateEvent event) throws EventNotFoundException {

        try {
            return new ResponseEntity<>(service.updateEventDetails(id, event), HttpStatus.ACCEPTED);
        } catch (EventNotFoundException e) {
            throw new EventNotFoundException("Event Not found for the id : " + id);
        }


    }


    @DeleteMapping("/event/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) throws EventNotFoundException {
        try {
            service.deleteEventById(id);
            return new ResponseEntity<>("The event is deleted for the given id: " + id, HttpStatus.OK);
        } catch (EventNotFoundException e) {
            throw new EventNotFoundException("Event not found for the given id :" + id);
        }
    }

}
