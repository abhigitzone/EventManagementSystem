package com.stackroute.organizerservice.util;

import com.stackroute.organizerservice.document.Event;
import com.stackroute.organizerservice.dto.EventDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrganizerIUtil {


    public EventDetails eventToEventDetails(Event event) {
        EventDetails eventDetails = new EventDetails();
        eventDetails.setEventId(event.getEventId());
        eventDetails.setEventName(event.getEventName());
        eventDetails.setEventAmount(event.getEventAmount());
        eventDetails.setEventDate(event.getEventDate());
        eventDetails.setEventVenue(event.getEventVenue());
        eventDetails.setEventCapacity(event.getEventCapacity());
        eventDetails.setEventDescription(event.getEventDescription());
        eventDetails.setStartTime(event.getStartTime());
        eventDetails.setEndTime(event.getEndTime());
        eventDetails.setUserEmail(event.getUserEmail());
        eventDetails.setUserName(event.getUserName());
        return eventDetails;
    }

    public EventDetails updateEventToEventDetails(Event event) {
        EventDetails eventDetails = new EventDetails();
        eventDetails.setEventId(event.getEventId());
        eventDetails.setEventName(event.getEventName());
        eventDetails.setEventAmount(event.getEventAmount());
        eventDetails.setEventDate(event.getEventDate());
        eventDetails.setEventVenue(event.getEventVenue());
        eventDetails.setEventCapacity(event.getEventCapacity());
        eventDetails.setEventDescription(event.getEventDescription());
        eventDetails.setStartTime(event.getStartTime());
        eventDetails.setEndTime(event.getEndTime());
        eventDetails.setUserName(event.getUserName());
        eventDetails.setUserEmail(event.getUserEmail());
        return eventDetails;
    }

    public List<EventDetails> allEvents(List<Event> entityList) {
        List<EventDetails> eventList = entityList.stream().map(this::eventToEventDetails).collect(Collectors.toList());
        return eventList;
    }


}
