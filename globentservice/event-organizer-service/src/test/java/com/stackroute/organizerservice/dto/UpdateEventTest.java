package com.stackroute.organizerservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class UpdateEventTest {
    /**
     * Method under test: {@link UpdateEvent#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new UpdateEvent()).canEqual("Other"));
    }

    /**
     * Method under test: {@link UpdateEvent#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        UpdateEvent updateEvent = new UpdateEvent();

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(3);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(3L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertTrue(updateEvent.canEqual(updateEvent1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link UpdateEvent}
     *   <li>{@link UpdateEvent#setEndTime(String)}
     *   <li>{@link UpdateEvent#setEventAmount(Double)}
     *   <li>{@link UpdateEvent#setEventCapacity(Integer)}
     *   <li>{@link UpdateEvent#setEventDate(LocalDate)}
     *   <li>{@link UpdateEvent#setEventDescription(String)}
     *   <li>{@link UpdateEvent#setEventName(String)}
     *   <li>{@link UpdateEvent#setEventVenue(String)}
     *   <li>{@link UpdateEvent#setStartTime(String)}
     *   <li>{@link UpdateEvent#setUserEmail(String)}
     *   <li>{@link UpdateEvent#setUserName(String)}
     *   <li>{@link UpdateEvent#toString()}
     *   <li>{@link UpdateEvent#getEndTime()}
     *   <li>{@link UpdateEvent#getEventAmount()}
     *   <li>{@link UpdateEvent#getEventCapacity()}
     *   <li>{@link UpdateEvent#getEventDate()}
     *   <li>{@link UpdateEvent#getEventDescription()}
     *   <li>{@link UpdateEvent#getEventName()}
     *   <li>{@link UpdateEvent#getEventVenue()}
     *   <li>{@link UpdateEvent#getStartTime()}
     *   <li>{@link UpdateEvent#getUserEmail()}
     *   <li>{@link UpdateEvent#getUserName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UpdateEvent actualUpdateEvent = new UpdateEvent();
        actualUpdateEvent.setEndTime("End Time");
        actualUpdateEvent.setEventAmount(10.0d);
        actualUpdateEvent.setEventCapacity(1);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualUpdateEvent.setEventDate(ofEpochDayResult);
        actualUpdateEvent.setEventDescription("Event Description");
        actualUpdateEvent.setEventName("Event Name");
        actualUpdateEvent.setEventVenue("Event Venue");
        actualUpdateEvent.setStartTime("Start Time");
        actualUpdateEvent.setUserEmail("jane.doe@example.org");
        actualUpdateEvent.setUserName("janedoe");
        String actualToStringResult = actualUpdateEvent.toString();
        assertEquals("End Time", actualUpdateEvent.getEndTime());
        assertEquals(10.0d, actualUpdateEvent.getEventAmount().doubleValue());
        assertEquals(1, actualUpdateEvent.getEventCapacity().intValue());
        assertSame(ofEpochDayResult, actualUpdateEvent.getEventDate());
        assertEquals("Event Description", actualUpdateEvent.getEventDescription());
        assertEquals("Event Name", actualUpdateEvent.getEventName());
        assertEquals("Event Venue", actualUpdateEvent.getEventVenue());
        assertEquals("Start Time", actualUpdateEvent.getStartTime());
        assertEquals("jane.doe@example.org", actualUpdateEvent.getUserEmail());
        assertEquals("janedoe", actualUpdateEvent.getUserName());
        assertEquals("UpdateEvent(eventName=Event Name, eventDescription=Event Description, eventVenue=Event Venue,"
                + " eventDate=1970-01-02, startTime=Start Time, endTime=End Time, eventAmount=10.0, eventCapacity=1,"
                + " userName=janedoe, userEmail=jane.doe@example.org)", actualToStringResult);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals() {
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
        assertNotEquals(updateEvent, null);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals2() {
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
        assertNotEquals(updateEvent, "Different type to UpdateEvent");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdateEvent#equals(Object)}
     *   <li>{@link UpdateEvent#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
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
        assertEquals(updateEvent, updateEvent);
        int expectedHashCodeResult = updateEvent.hashCode();
        assertEquals(expectedHashCodeResult, updateEvent.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdateEvent#equals(Object)}
     *   <li>{@link UpdateEvent#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
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

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertEquals(updateEvent, updateEvent1);
        int expectedHashCodeResult = updateEvent.hashCode();
        assertEquals(expectedHashCodeResult, updateEvent1.hashCode());
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals5() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("Event Name");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals6() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime(null);
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals7() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(null);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals8() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(0.5d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals9() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(3);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals10() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(null);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals11() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(3L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals12() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(null);
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals13() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Name");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals14() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription(null);
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals15() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Description");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals16() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName(null);
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals17() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Name");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals18() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue(null);
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals19() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Event Name");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals20() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime(null);
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals21() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("Event Name");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals22() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail(null);
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals23() {
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
        updateEvent.setUserName("Event Name");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Method under test: {@link UpdateEvent#equals(Object)}
     */
    @Test
    void testEquals24() {
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
        updateEvent.setUserName(null);

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertNotEquals(updateEvent, updateEvent1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdateEvent#equals(Object)}
     *   <li>{@link UpdateEvent#hashCode()}
     * </ul>
     */
    @Test
    void testEquals25() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime(null);
        updateEvent.setEventAmount(10.0d);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime(null);
        updateEvent1.setEventAmount(10.0d);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertEquals(updateEvent, updateEvent1);
        int expectedHashCodeResult = updateEvent.hashCode();
        assertEquals(expectedHashCodeResult, updateEvent1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdateEvent#equals(Object)}
     *   <li>{@link UpdateEvent#hashCode()}
     * </ul>
     */
    @Test
    void testEquals26() {
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setEndTime("End Time");
        updateEvent.setEventAmount(null);
        updateEvent.setEventCapacity(1);
        updateEvent.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent.setEventDescription("Event Description");
        updateEvent.setEventName("Event Name");
        updateEvent.setEventVenue("Event Venue");
        updateEvent.setStartTime("Start Time");
        updateEvent.setUserEmail("jane.doe@example.org");
        updateEvent.setUserName("janedoe");

        UpdateEvent updateEvent1 = new UpdateEvent();
        updateEvent1.setEndTime("End Time");
        updateEvent1.setEventAmount(null);
        updateEvent1.setEventCapacity(1);
        updateEvent1.setEventDate(LocalDate.ofEpochDay(1L));
        updateEvent1.setEventDescription("Event Description");
        updateEvent1.setEventName("Event Name");
        updateEvent1.setEventVenue("Event Venue");
        updateEvent1.setStartTime("Start Time");
        updateEvent1.setUserEmail("jane.doe@example.org");
        updateEvent1.setUserName("janedoe");
        assertEquals(updateEvent, updateEvent1);
        int expectedHashCodeResult = updateEvent.hashCode();
        assertEquals(expectedHashCodeResult, updateEvent1.hashCode());
    }
}

