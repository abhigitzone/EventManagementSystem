package com.stackroute.organizerservice.service;

import com.stackroute.organizerservice.document.Event;
import com.stackroute.organizerservice.dto.EventDetails;
import com.stackroute.organizerservice.dto.UpdateEvent;
import com.stackroute.organizerservice.exception.EventNotFoundException;
import com.stackroute.organizerservice.exception.InvalidArgumentException;
import com.stackroute.organizerservice.repository.OrganizerRepository;
import com.stackroute.organizerservice.util.OrganizerIUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {OrganizerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class OrganizerServiceImplTest {
    @MockBean
    private OrganizerIUtil organizerIUtil;

    @MockBean
    private OrganizerRepository organizerRepository;

    @Autowired
    private OrganizerServiceImpl organizerServiceImpl;



    @Test
    void testEventsList() throws EventNotFoundException {
        when(organizerRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(EventNotFoundException.class, () -> organizerServiceImpl.eventsList());
        verify(organizerRepository, atLeast(1)).findAll();
    }


    @Test
    void testEventsList2() throws EventNotFoundException {
        Event event = new Event();
        event.setEndTime("No Events Found ");
        event.setEventAmount(10.0d);
        event.setEventCapacity(1);
        event.setEventDate(LocalDate.ofEpochDay(1L));
        event.setEventDescription("No Events Found ");
        event.setEventId(123);
        event.setEventName("No Events Found ");
        event.setEventVenue("No Events Found ");
        event.setStartTime("No Events Found ");
        event.setUserEmail("jane.doe@example.org");
        event.setUserName("janedoe");

        ArrayList<Event> eventList = new ArrayList<>();
        eventList.add(event);
        when(organizerRepository.findAll()).thenReturn(eventList);
        ArrayList<EventDetails> eventDetailsList = new ArrayList<>();
        when(organizerIUtil.allEvents((List<Event>) any())).thenReturn(eventDetailsList);
        List<EventDetails> actualEventsListResult = organizerServiceImpl.eventsList();
        assertSame(eventDetailsList, actualEventsListResult);
        assertTrue(actualEventsListResult.isEmpty());
        verify(organizerRepository, atLeast(1)).findAll();
        verify(organizerIUtil).allEvents((List<Event>) any());
    }

    @Test
    void testDeleteEventById() throws EventNotFoundException {
        Event event = new Event();
        event.setEndTime("End Time");
        event.setEventAmount(10.0d);
        event.setEventCapacity(1);
        event.setEventDate(LocalDate.ofEpochDay(1L));
        event.setEventDescription("Event Description");
        event.setEventId(123);
        event.setEventName("Event Name");
        event.setEventVenue("Event Venue");
        event.setStartTime("Start Time");
        event.setUserEmail("jane.doe@example.org");
        event.setUserName("janedoe");
        Optional<Event> ofResult = Optional.of(event);
        doNothing().when(organizerRepository).deleteById((Integer) any());
        when(organizerRepository.findById((Integer) any())).thenReturn(ofResult);
        organizerServiceImpl.deleteEventById(123);
        verify(organizerRepository).findById((Integer) any());
        verify(organizerRepository).deleteById((Integer) any());
    }

    @Test
    void testDeleteEventById2() throws EventNotFoundException {
        doNothing().when(organizerRepository).deleteById((Integer) any());
        when(organizerRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(EventNotFoundException.class, () -> organizerServiceImpl.deleteEventById(123));
        verify(organizerRepository).findById((Integer) any());
    }


    @Test
    void testUpdateEventDetails() throws EventNotFoundException {
        Event event = new Event();
        event.setEndTime("End Time");
        event.setEventAmount(10.0d);
        event.setEventCapacity(1);
        event.setEventDate(LocalDate.ofEpochDay(1L));
        event.setEventDescription("Event Description");
        event.setEventId(123);
        event.setEventName("Event Name");
        event.setEventVenue("Event Venue");
        event.setStartTime("Start Time");
        event.setUserEmail("jane.doe@example.org");
        event.setUserName("janedoe");
        Optional<Event> ofResult = Optional.of(event);

        Event event1 = new Event();
        event1.setEndTime("End Time");
        event1.setEventAmount(10.0d);
        event1.setEventCapacity(1);
        event1.setEventDate(LocalDate.ofEpochDay(1L));
        event1.setEventDescription("Event Description");
        event1.setEventId(123);
        event1.setEventName("Event Name");
        event1.setEventVenue("Event Venue");
        event1.setStartTime("Start Time");
        event1.setUserEmail("jane.doe@example.org");
        event1.setUserName("janedoe");
        when(organizerRepository.save((Event) any())).thenReturn(event1);
        when(organizerRepository.findById((Integer) any())).thenReturn(ofResult);

        EventDetails eventDetails = new EventDetails();
        eventDetails.setEndTime("End Time");
        eventDetails.setEventAmount(10.0d);
        eventDetails.setEventCapacity(1);
        eventDetails.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetails.setEventDescription("Event Description");
        eventDetails.setEventId(123);
        eventDetails.setEventName("Event Name");
        eventDetails.setEventVenue("Event Venue");
        eventDetails.setStartTime("Start Time");
        eventDetails.setUserEmail("jane.doe@example.org");
        eventDetails.setUserName("janedoe");
        when(organizerIUtil.updateEventToEventDetails((Event) any())).thenReturn(eventDetails);

        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");
        assertSame(eventDetails, organizerServiceImpl.updateEventDetails(1, updateEvent));
        verify(organizerRepository).save((Event) any());
        verify(organizerRepository).findById((Integer) any());
        verify(organizerIUtil).updateEventToEventDetails((Event) any());
    }


    @Test
    void testEventByUserName2() throws EventNotFoundException, InvalidArgumentException {
        Event event = new Event();
        event.setEndTime("End Time");
        event.setEventAmount(10.0d);
        event.setEventCapacity(1);
        event.setEventDate(LocalDate.ofEpochDay(1L));
        event.setEventDescription("Event Description");
        event.setEventId(123);
        event.setEventName("Event Name");
        event.setEventVenue("Event Venue");
        event.setStartTime("Start Time");
        event.setUserEmail("jane.doe@example.org");
        event.setUserName("janedoe");

        ArrayList<Event> eventList = new ArrayList<>();
        eventList.add(event);
        when(organizerRepository.findAll()).thenReturn(eventList);

        EventDetails eventDetails = new EventDetails();
        eventDetails.setEndTime("End Time");
        eventDetails.setEventAmount(10.0d);
        eventDetails.setEventCapacity(1);
        eventDetails.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetails.setEventDescription("Event Description");
        eventDetails.setEventId(123);
        eventDetails.setEventName("Event Name");
        eventDetails.setEventVenue("Event Venue");
        eventDetails.setStartTime("Start Time");
        eventDetails.setUserEmail("jane.doe@example.org");
        eventDetails.setUserName("janedoe");
        when(organizerIUtil.eventToEventDetails((Event) any())).thenReturn(eventDetails);
        assertSame(eventDetails, organizerServiceImpl.eventByUserName("janedoe"));
        verify(organizerRepository).findAll();
        verify(organizerIUtil).eventToEventDetails((Event) any());
    }


}

