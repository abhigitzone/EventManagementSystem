package com.stackroute.organizerservice.service;

import com.stackroute.organizerservice.document.Event;
import com.stackroute.organizerservice.dto.AddEvent;
import com.stackroute.organizerservice.dto.EventDetails;
import com.stackroute.organizerservice.dto.UpdateEvent;
import com.stackroute.organizerservice.exception.EventNotFoundException;
import com.stackroute.organizerservice.exception.InvalidArgumentException;
import com.stackroute.organizerservice.repository.OrganizerRepository;
import com.stackroute.organizerservice.util.OrganizerIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizerServiceImpl implements IOrganizerService {


    @Autowired
    private OrganizerRepository repo;

    @Autowired
    private OrganizerIUtil util;
    private int id;

    public int generateId() {
        return ++id;
    }


    @Transactional
    @Override
    public EventDetails addEventDetails(AddEvent eventDetails) {
        Event event = new Event();
        event.setEventId(generateId());
        event.setEventName(eventDetails.getEventName());
        event.setEventCapacity(eventDetails.getEventCapacity());
        event.setEventDate(eventDetails.getEventDate());
        event.setEventAmount(eventDetails.getEventAmount());
        event.setStartTime(eventDetails.getStartTime());
        event.setEndTime(eventDetails.getEndTime());
        event.setEventDescription(eventDetails.getEventDescription());
        event.setEventVenue(eventDetails.getEventVenue());
        event.setUserName(eventDetails.getUserName());
        event.setUserEmail(eventDetails.getUserEmail());
        event = repo.save(event);
        EventDetails desired = util.eventToEventDetails(event);
        return desired;
    }

    @Transactional
    @Override
    public List<EventDetails> eventsList() throws EventNotFoundException {
        List<Event> list = repo.findAll();
        if(repo.findAll().isEmpty()){
           throw new EventNotFoundException("No Events Found ");
        }
        List<EventDetails> eventDetails = util.allEvents(list);
        return eventDetails;
    }

    @Transactional
    @Override
    public void deleteEventById(@NotNull Integer eventId) throws EventNotFoundException {
        Event event = findById(eventId);
        if (event == null) {
            throw new EventNotFoundException("Event doesn't exist for the given id" + eventId);
        }
        repo.deleteById(eventId);
    }


    @Transactional
    @Override
    public Event findById(Integer eventId) throws EventNotFoundException {

        Optional<Event> entity = repo.findById(eventId);
        if (entity.isEmpty()) {
            throw new EventNotFoundException("Event Not found for the id : " + eventId);
        }
        return entity.get();

    }

    @Transactional
    @Override
    public EventDetails updateEventDetails(Integer id, UpdateEvent event) throws EventNotFoundException {

        Event existingEvent = findById(id);
        if (existingEvent == null) {
            throw new EventNotFoundException("Event not found for the id :" + id);
        }
        existingEvent.getEventId();
        existingEvent.setEventName(event.getEventName() != null ? event.getEventName() : existingEvent.getEventName());
        existingEvent.setEventAmount(event.getEventAmount() != null ? event.getEventAmount() : existingEvent.getEventAmount());
        existingEvent.setEventDate(event.getEventDate() != null ? event.getEventDate() : existingEvent.getEventDate());
        existingEvent.setEventDescription(event.getEventDescription() != null ? event.getEventDescription() : existingEvent.getEventDescription());
        existingEvent.setEventCapacity(event.getEventCapacity() != null ? event.getEventCapacity() : existingEvent.getEventCapacity());
        existingEvent.setStartTime(event.getStartTime() != null ? event.getStartTime() : existingEvent.getStartTime());
        existingEvent.setEndTime(event.getEndTime() != null ? event.getEndTime() : existingEvent.getEndTime());
        existingEvent.setEventVenue(event.getEventVenue() != null ? event.getEventVenue() : existingEvent.getEventVenue());
        existingEvent.setUserEmail(event.getUserEmail() != null ? event.getUserEmail() : existingEvent.getUserEmail());
        existingEvent.setUserName(event.getUserName() != null ? event.getUserName() : existingEvent.getUserName());
        existingEvent = repo.save(existingEvent);

        EventDetails newEvent = util.updateEventToEventDetails(existingEvent);
        return newEvent;


    }

    @Transactional
    @Override
    public EventDetails eventByUserName(@Min(message = "username cannot be empty ", value = 3) String userName) throws EventNotFoundException, InvalidArgumentException {
        Optional<Event> event = repo.findAll().stream().filter(event1 -> event1.getUserName().equalsIgnoreCase(userName)).findFirst();
        event = Optional.of(event.get());
        return util.eventToEventDetails(event.get());

    }

}