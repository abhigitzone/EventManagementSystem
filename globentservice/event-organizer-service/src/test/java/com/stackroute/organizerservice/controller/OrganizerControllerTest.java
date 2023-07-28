package com.stackroute.organizerservice.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.organizerservice.document.Event;
import com.stackroute.organizerservice.dto.AddEvent;
import com.stackroute.organizerservice.dto.EventDetails;
import com.stackroute.organizerservice.dto.UpdateEvent;
import com.stackroute.organizerservice.service.OrganizerServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {OrganizerController.class})
@ExtendWith(SpringExtension.class)
class OrganizerControllerTest {
    @Autowired
    private OrganizerController organizerController;

    @MockBean
    private OrganizerServiceImpl organizerServiceImpl;

    @MockBean
    private RabbitTemplate rabbitTemplate;


    @Test
    void testAddEvent() throws Exception {
        AddEvent addEvent = new AddEvent();
        addEvent.setEndTime("End Time");
        addEvent.setEventAmount(10.0d);
        addEvent.setEventCapacity(1);
        addEvent.setEventDate(LocalDate.ofEpochDay(1L));
        addEvent.setEventDescription("Event Description");
        addEvent.setEventName("Event Name");
        addEvent.setEventVenue("Event Venue");
        addEvent.setStartTime("Start Time");
        addEvent.setUserEmail("jane.doe@example.org");
        addEvent.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(addEvent);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/event/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(organizerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }


    @Test
    void testFindById() throws Exception {
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
        when(organizerServiceImpl.findById((Integer) any())).thenReturn(event);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/events/id/{id}", 1);
        MockMvcBuilders.standaloneSetup(organizerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"eventId\":123,\"eventName\":\"Event Name\",\"eventDescription\":\"Event Description\",\"eventVenue\":\"Event"
                                        + " Venue\",\"eventDate\":[1970,1,2],\"startTime\":\"Start Time\",\"endTime\":\"End Time\",\"eventAmount\":10.0,"
                                        + "\"eventCapacity\":1,\"userName\":\"janedoe\",\"userEmail\":\"jane.doe@example.org\"}"));
    }


    @Test
    void testAllEvents() throws Exception {
        when(organizerServiceImpl.eventsList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/event");
        MockMvcBuilders.standaloneSetup(organizerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }




    @Test
    void testDeleteById() throws Exception {
        doNothing().when(organizerServiceImpl).deleteEventById((Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/event/{id}", 1);
        MockMvcBuilders.standaloneSetup(organizerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("The event is deleted for the given id: 1"));
    }


    @Test
    void testEventDetailsByUserName() throws Exception {
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
        when(organizerServiceImpl.eventByUserName((String) any())).thenReturn(eventDetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/event/name/{name}", "Name");
        MockMvcBuilders.standaloneSetup(organizerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"eventId\":123,\"eventName\":\"Event Name\",\"eventDescription\":\"Event Description\",\"eventVenue\":\"Event"
                                        + " Venue\",\"eventDate\":[1970,1,2],\"startTime\":\"Start Time\",\"endTime\":\"End Time\",\"eventAmount\":10.0,"
                                        + "\"eventCapacity\":1,\"userName\":\"janedoe\",\"userEmail\":\"jane.doe@example.org\"}"));
    }


    @Test
    void testUpdateEvent() throws Exception {
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
        String content = (new ObjectMapper()).writeValueAsString(updateEvent);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/event/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(organizerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }


}

