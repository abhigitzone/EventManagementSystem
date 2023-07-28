package com.stackroute.organizerservice.service;

import com.stackroute.organizerservice.document.Event;
import com.stackroute.organizerservice.dto.AddEvent;
import com.stackroute.organizerservice.dto.EventDetails;
import com.stackroute.organizerservice.dto.UpdateEvent;
import com.stackroute.organizerservice.exception.EventNotFoundException;
import com.stackroute.organizerservice.exception.InvalidArgumentException;

import java.util.List;


public interface IOrganizerService {
    EventDetails addEventDetails( AddEvent eventDetails);

    List<EventDetails> eventsList() throws EventNotFoundException;

    void deleteEventById(Integer eventId) throws EventNotFoundException;

    Event findById(Integer eventId) throws EventNotFoundException;


    EventDetails updateEventDetails( Integer id , UpdateEvent event) throws EventNotFoundException;

   EventDetails eventByUserName( String userName) throws EventNotFoundException, InvalidArgumentException;
}
