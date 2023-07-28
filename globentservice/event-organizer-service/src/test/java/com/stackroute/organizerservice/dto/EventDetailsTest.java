package com.stackroute.organizerservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class EventDetailsTest {

    @Test
    void testCanEqual() {
        assertFalse((new EventDetails()).canEqual("Other"));
    }


    @Test
    void testCanEqual2() {
        EventDetails eventDetails = new EventDetails();

        EventDetails eventDetails1 = new EventDetails();
        eventDetails1.setEndTime("End Time");
        eventDetails1.setEventAmount(10.0d);
        eventDetails1.setEventCapacity(3);
        eventDetails1.setEventDate(LocalDate.ofEpochDay(3L));
        eventDetails1.setEventDescription("Event Description");
        eventDetails1.setEventId(123);
        eventDetails1.setEventName("Event Name");
        eventDetails1.setEventVenue("Event Venue");
        eventDetails1.setStartTime("Start Time");
        eventDetails1.setUserEmail("jane.doe@example.org");
        eventDetails1.setUserName("janedoe");
        assertTrue(eventDetails.canEqual(eventDetails1));
    }


    @Test
    void testConstructor() {
        EventDetails actualEventDetails = new EventDetails();
        actualEventDetails.setEndTime("End Time");
        actualEventDetails.setEventAmount(10.0d);
        actualEventDetails.setEventCapacity(1);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualEventDetails.setEventDate(ofEpochDayResult);
        actualEventDetails.setEventDescription("Event Description");
        actualEventDetails.setEventId(123);
        actualEventDetails.setEventName("Event Name");
        actualEventDetails.setEventVenue("Event Venue");
        actualEventDetails.setStartTime("Start Time");
        actualEventDetails.setUserEmail("jane.doe@example.org");
        actualEventDetails.setUserName("janedoe");
        String actualToStringResult = actualEventDetails.toString();
        assertEquals("End Time", actualEventDetails.getEndTime());
        assertEquals(10.0d, actualEventDetails.getEventAmount().doubleValue());
        assertEquals(1, actualEventDetails.getEventCapacity().intValue());
        assertSame(ofEpochDayResult, actualEventDetails.getEventDate());
        assertEquals("Event Description", actualEventDetails.getEventDescription());
        assertEquals(123, actualEventDetails.getEventId());
        assertEquals("Event Name", actualEventDetails.getEventName());
        assertEquals("Event Venue", actualEventDetails.getEventVenue());
        assertEquals("Start Time", actualEventDetails.getStartTime());
        assertEquals("jane.doe@example.org", actualEventDetails.getUserEmail());
        assertEquals("janedoe", actualEventDetails.getUserName());
        assertEquals("EventDetails(eventId=123, eventName=Event Name, eventDescription=Event Description, eventVenue=Event"
                + " Venue, eventDate=1970-01-02, startTime=Start Time, endTime=End Time, eventAmount=10.0, eventCapacity=1,"
                + " userName=janedoe, userEmail=jane.doe@example.org)", actualToStringResult);
    }


    @Test
    void testEquals() {
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
        assertNotEquals(eventDetails, null);
    }


    @Test
    void testEquals2() {
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
        assertNotEquals(eventDetails, "Different type to EventDetails");
    }


    @Test
    void testEquals3() {
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
        assertEquals(eventDetails, eventDetails);
        int expectedHashCodeResult = eventDetails.hashCode();
        assertEquals(expectedHashCodeResult, eventDetails.hashCode());
    }


    @Test
    void testEquals4() {
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
        eventDetails.setUserName("Event Name");

        EventDetails eventDetails1 = new EventDetails();
        eventDetails1.setEndTime("End Time");
        eventDetails1.setEventAmount(10.0d);
        eventDetails1.setEventCapacity(1);
        eventDetails1.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetails1.setEventDescription("Event Description");
        eventDetails1.setEventId(123);
        eventDetails1.setEventName("Event Name");
        eventDetails1.setEventVenue("Event Venue");
        eventDetails1.setStartTime("Start Time");
        eventDetails1.setUserEmail("jane.doe@example.org");
        eventDetails1.setUserName("janedoe");
        assertNotEquals(eventDetails, eventDetails1);
    }


    @Test
    void testEquals5() {
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
        eventDetails.setUserName(null);

        EventDetails eventDetails1 = new EventDetails();
        eventDetails1.setEndTime("End Time");
        eventDetails1.setEventAmount(10.0d);
        eventDetails1.setEventCapacity(1);
        eventDetails1.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetails1.setEventDescription("Event Description");
        eventDetails1.setEventId(123);
        eventDetails1.setEventName("Event Name");
        eventDetails1.setEventVenue("Event Venue");
        eventDetails1.setStartTime("Start Time");
        eventDetails1.setUserEmail("jane.doe@example.org");
        eventDetails1.setUserName("janedoe");
        assertNotEquals(eventDetails, eventDetails1);
    }
}

