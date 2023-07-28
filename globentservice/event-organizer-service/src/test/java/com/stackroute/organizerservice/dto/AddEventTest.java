package com.stackroute.organizerservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class AddEventTest {

    @Test
    void testCanEqual() {
        assertFalse((new AddEvent()).canEqual("Other"));
    }


    @Test
    void testCanEqual2() {
        AddEvent addEvent = new AddEvent();
        assertTrue(addEvent.canEqual(new AddEvent()));
    }


    @Test
    void testConstructor() {
        AddEvent actualAddEvent = new AddEvent();
        actualAddEvent.setEndTime("End Time");
        actualAddEvent.setEventAmount(10.0d);
        actualAddEvent.setEventCapacity(1);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualAddEvent.setEventDate(ofEpochDayResult);
        actualAddEvent.setEventDescription("Event Description");
        actualAddEvent.setEventName("Event Name");
        actualAddEvent.setEventVenue("Event Venue");
        actualAddEvent.setStartTime("Start Time");
        actualAddEvent.setUserEmail("jane.doe@example.org");
        actualAddEvent.setUserName("janedoe");
        String actualToStringResult = actualAddEvent.toString();
        assertEquals("End Time", actualAddEvent.getEndTime());
        assertEquals(10.0d, actualAddEvent.getEventAmount().doubleValue());
        assertEquals(1, actualAddEvent.getEventCapacity().intValue());
        assertSame(ofEpochDayResult, actualAddEvent.getEventDate());
        assertEquals("Event Description", actualAddEvent.getEventDescription());
        assertEquals("Event Name", actualAddEvent.getEventName());
        assertEquals("Event Venue", actualAddEvent.getEventVenue());
        assertEquals("Start Time", actualAddEvent.getStartTime());
        assertEquals("jane.doe@example.org", actualAddEvent.getUserEmail());
        assertEquals("janedoe", actualAddEvent.getUserName());
        assertEquals("AddEvent(eventName=Event Name, eventDescription=Event Description, eventVenue=Event Venue, eventDate"
                + "=1970-01-02, startTime=Start Time, endTime=End Time, eventAmount=10.0, eventCapacity=1, userName=janedoe,"
                + " userEmail=jane.doe@example.org)", actualToStringResult);
    }


    @Test
    void testConstructor2() {
        AddEvent actualAddEvent = new AddEvent("Event Name", "Event Description", "Event Venue", LocalDate.ofEpochDay(1L),
                "Start Time", "End Time", 10.0d, 1, "janedoe", "jane.doe@example.org");
        actualAddEvent.setEndTime("End Time");
        actualAddEvent.setEventAmount(10.0d);
        actualAddEvent.setEventCapacity(1);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualAddEvent.setEventDate(ofEpochDayResult);
        actualAddEvent.setEventDescription("Event Description");
        actualAddEvent.setEventName("Event Name");
        actualAddEvent.setEventVenue("Event Venue");
        actualAddEvent.setStartTime("Start Time");
        actualAddEvent.setUserEmail("jane.doe@example.org");
        actualAddEvent.setUserName("janedoe");
        String actualToStringResult = actualAddEvent.toString();
        assertEquals("End Time", actualAddEvent.getEndTime());
        assertEquals(10.0d, actualAddEvent.getEventAmount().doubleValue());
        assertEquals(1, actualAddEvent.getEventCapacity().intValue());
        assertSame(ofEpochDayResult, actualAddEvent.getEventDate());
        assertEquals("Event Description", actualAddEvent.getEventDescription());
        assertEquals("Event Name", actualAddEvent.getEventName());
        assertEquals("Event Venue", actualAddEvent.getEventVenue());
        assertEquals("Start Time", actualAddEvent.getStartTime());
        assertEquals("jane.doe@example.org", actualAddEvent.getUserEmail());
        assertEquals("janedoe", actualAddEvent.getUserName());
        assertEquals(
                "AddEvent(eventName=Event Name, eventDescription=Event Description, eventVenue=Event Venue, eventDate"
                        + "=1970-01-02, startTime=Start Time, endTime=End Time, eventAmount=10.0, eventCapacity=1, userName=janedoe,"
                        + " userEmail=jane.doe@example.org)",
                actualToStringResult);
    }


    @Test
    void testEquals() {
        assertNotEquals(new AddEvent(), null);
        assertNotEquals(new AddEvent(), "Different type to AddEvent");
    }


    @Test
    void testEquals2() {
        AddEvent addEvent = new AddEvent();
        assertEquals(addEvent, addEvent);
        int expectedHashCodeResult = addEvent.hashCode();
        assertEquals(expectedHashCodeResult, addEvent.hashCode());
    }


    @Test
    void testEquals3() {
        AddEvent addEvent = new AddEvent();
        AddEvent addEvent1 = new AddEvent();
        assertEquals(addEvent, addEvent1);
        int expectedHashCodeResult = addEvent.hashCode();
        assertEquals(expectedHashCodeResult, addEvent1.hashCode());
    }


    @Test
    void testEquals4() {
        AddEvent addEvent = new AddEvent("Event Name", "Event Description", "Event Venue", LocalDate.ofEpochDay(1L),
                "Start Time", "End Time", 10.0d, 1, "janedoe", "jane.doe@example.org");
        assertNotEquals(addEvent, new AddEvent());
    }


    @Test
    void testEquals5() {
        AddEvent addEvent = new AddEvent();
        assertNotEquals(addEvent, new AddEvent("Event Name", "Event Description", "Event Venue", LocalDate.ofEpochDay(1L),
                "Start Time", "End Time", 10.0d, 1, "janedoe", "jane.doe@example.org"));
    }

    @Test
    void testEquals6() {
        AddEvent addEvent = new AddEvent();
        addEvent.setEventName("Event Name");
        assertNotEquals(addEvent, new AddEvent());
    }


    @Test
    void testEquals7() {
        AddEvent addEvent = new AddEvent();
        addEvent.setEventDescription("Event Description");
        assertNotEquals(addEvent, new AddEvent());
    }


    @Test
    void testEquals8() {
        AddEvent addEvent = new AddEvent();
        addEvent.setEventVenue("Event Venue");
        assertNotEquals(addEvent, new AddEvent());
    }


    @Test
    void testEquals9() {
        AddEvent addEvent = new AddEvent();
        addEvent.setEventDate(LocalDate.ofEpochDay(1L));
        assertNotEquals(addEvent, new AddEvent());
    }

    @Test
    void testEquals10() {
        AddEvent addEvent = new AddEvent();
        addEvent.setStartTime("Start Time");
        assertNotEquals(addEvent, new AddEvent());
    }


    @Test
    void testEquals11() {
        AddEvent addEvent = new AddEvent();
        addEvent.setEndTime("End Time");
        assertNotEquals(addEvent, new AddEvent());
    }


    @Test
    void testEquals12() {
        AddEvent addEvent = new AddEvent();
        addEvent.setEventCapacity(1);
        assertNotEquals(addEvent, new AddEvent());
    }


    @Test
    void testEquals13() {
        AddEvent addEvent = new AddEvent();
        addEvent.setUserName("janedoe");
        assertNotEquals(addEvent, new AddEvent());
    }

    @Test
    void testEquals14() {
        AddEvent addEvent = new AddEvent();
        addEvent.setUserEmail("jane.doe@example.org");
        assertNotEquals(addEvent, new AddEvent());
    }

    @Test
    void testEquals15() {
        AddEvent addEvent = new AddEvent("Event Name", "Event Description", "Event Venue", LocalDate.ofEpochDay(1L),
                "Start Time", "End Time", 10.0d, 1, "janedoe", "jane.doe@example.org");
        AddEvent addEvent1 = new AddEvent("Event Name", "Event Description", "Event Venue", LocalDate.ofEpochDay(1L),
                "Start Time", "End Time", 10.0d, 1, "janedoe", "jane.doe@example.org");

        assertEquals(addEvent, addEvent1);
        int expectedHashCodeResult = addEvent.hashCode();
        assertEquals(expectedHashCodeResult, addEvent1.hashCode());
    }


    @Test
    void testEquals16() {
        AddEvent addEvent = new AddEvent();

        AddEvent addEvent1 = new AddEvent();
        addEvent1.setEventName("Event Name");
        assertNotEquals(addEvent, addEvent1);
    }


    @Test
    void testEquals17() {
        AddEvent addEvent = new AddEvent();

        AddEvent addEvent1 = new AddEvent();
        addEvent1.setEventDescription("Event Description");
        assertNotEquals(addEvent, addEvent1);
    }


    @Test
    void testEquals18() {
        AddEvent addEvent = new AddEvent();

        AddEvent addEvent1 = new AddEvent();
        addEvent1.setEventVenue("Event Venue");
        assertNotEquals(addEvent, addEvent1);
    }


    @Test
    void testEquals19() {
        AddEvent addEvent = new AddEvent();

        AddEvent addEvent1 = new AddEvent();
        addEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        assertNotEquals(addEvent, addEvent1);
    }


    @Test
    void testEquals20() {
        AddEvent addEvent = new AddEvent();

        AddEvent addEvent1 = new AddEvent();
        addEvent1.setStartTime("Start Time");
        assertNotEquals(addEvent, addEvent1);
    }


    @Test
    void testEquals21() {
        AddEvent addEvent = new AddEvent();

        AddEvent addEvent1 = new AddEvent();
        addEvent1.setEndTime("End Time");
        assertNotEquals(addEvent, addEvent1);
    }


    @Test
    void testEquals22() {
        AddEvent addEvent = new AddEvent();

        AddEvent addEvent1 = new AddEvent();
        addEvent1.setEventCapacity(1);
        assertNotEquals(addEvent, addEvent1);
    }


    @Test
    void testEquals23() {
        AddEvent addEvent = new AddEvent();

        AddEvent addEvent1 = new AddEvent();
        addEvent1.setUserName("janedoe");
        assertNotEquals(addEvent, addEvent1);
    }


    @Test
    void testEquals24() {
        AddEvent addEvent = new AddEvent();

        AddEvent addEvent1 = new AddEvent();
        addEvent1.setUserEmail("jane.doe@example.org");
        assertNotEquals(addEvent, addEvent1);
    }
}

