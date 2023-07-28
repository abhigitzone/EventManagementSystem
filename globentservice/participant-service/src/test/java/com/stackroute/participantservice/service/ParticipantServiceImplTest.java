package com.stackroute.participantservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.stackroute.participantservice.dto.AddParticipantDto;
import com.stackroute.participantservice.dto.EventDetailsDto;
import com.stackroute.participantservice.dto.ParticipantDetails;
import com.stackroute.participantservice.dto.UpdateParticipantDto;
import com.stackroute.participantservice.entity.Participant;
import com.stackroute.participantservice.exception.ParticipantAreadyExistException;
import com.stackroute.participantservice.exception.ParticipantNotFoundException;
import com.stackroute.participantservice.repository.ParticipantRepository;
import com.stackroute.participantservice.util.ParticipantUtil;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ParticipantServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ParticipantServiceImplTest {
    @MockBean
    private ParticipantRepository participantRepository;

    @Autowired
    private ParticipantServiceImpl participantServiceImpl;

    @MockBean
    private ParticipantUtil participantUtil;

    /**
     * Method under test: {@link ParticipantServiceImpl#addParticipant(AddParticipantDto)}
     */
    @Test
    void testAddParticipant() throws ParticipantAreadyExistException {
        EventDetailsDto eventDetailsDto = new EventDetailsDto();
        eventDetailsDto.setEndTime("End Time");
        eventDetailsDto.setEventAmount(10.0d);
        eventDetailsDto.setEventCapacity(1);
        eventDetailsDto.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto.setEventDescription("Event Description");
        eventDetailsDto.setEventId(123);
        eventDetailsDto.setEventName("Event Name");
        eventDetailsDto.setEventVenue("Event Venue");
        eventDetailsDto.setStartTime("Start Time");
        eventDetailsDto.setUserEmail("jane.doe@example.org");
        eventDetailsDto.setUserName("janedoe");

        Participant participant = new Participant();
        participant.setEvent(eventDetailsDto);
        participant.setParticipantID(1);
        participant.setParticipantName("Participant Name");
        participant.setUserAge(1);
        participant.setUserName("janedoe");
        when(participantRepository.existsByParticipantName((String) any())).thenReturn(true);
        when(participantRepository.save((Participant) any())).thenReturn(participant);

        EventDetailsDto eventDetailsDto1 = new EventDetailsDto();
        eventDetailsDto1.setEndTime("End Time");
        eventDetailsDto1.setEventAmount(10.0d);
        eventDetailsDto1.setEventCapacity(1);
        eventDetailsDto1.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto1.setEventDescription("Event Description");
        eventDetailsDto1.setEventId(123);
        eventDetailsDto1.setEventName("Event Name");
        eventDetailsDto1.setEventVenue("Event Venue");
        eventDetailsDto1.setStartTime("Start Time");
        eventDetailsDto1.setUserEmail("jane.doe@example.org");
        eventDetailsDto1.setUserName("janedoe");

        AddParticipantDto addParticipantDto = new AddParticipantDto();
        addParticipantDto.setEvent(eventDetailsDto1);
        addParticipantDto.setParticipantName("Participant Name");
        addParticipantDto.setUserAge(1);
        addParticipantDto.setUserName("janedoe");
        assertThrows(ParticipantAreadyExistException.class, () -> participantServiceImpl.addParticipant(addParticipantDto));
        verify(participantRepository).existsByParticipantName((String) any());
    }

    /**
     * Method under test: {@link ParticipantServiceImpl#addParticipant(AddParticipantDto)}
     */
    @Test
    void testAddParticipant2() throws ParticipantAreadyExistException {
        EventDetailsDto eventDetailsDto = new EventDetailsDto();
        eventDetailsDto.setEndTime("End Time");
        eventDetailsDto.setEventAmount(10.0d);
        eventDetailsDto.setEventCapacity(1);
        eventDetailsDto.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto.setEventDescription("Event Description");
        eventDetailsDto.setEventId(123);
        eventDetailsDto.setEventName("Event Name");
        eventDetailsDto.setEventVenue("Event Venue");
        eventDetailsDto.setStartTime("Start Time");
        eventDetailsDto.setUserEmail("jane.doe@example.org");
        eventDetailsDto.setUserName("janedoe");

        Participant participant = new Participant();
        participant.setEvent(eventDetailsDto);
        participant.setParticipantID(1);
        participant.setParticipantName("Participant Name");
        participant.setUserAge(1);
        participant.setUserName("janedoe");
        when(participantRepository.existsByParticipantName((String) any())).thenReturn(false);
        when(participantRepository.save((Participant) any())).thenReturn(participant);

        EventDetailsDto eventDetailsDto1 = new EventDetailsDto();
        eventDetailsDto1.setEndTime("End Time");
        eventDetailsDto1.setEventAmount(10.0d);
        eventDetailsDto1.setEventCapacity(1);
        eventDetailsDto1.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto1.setEventDescription("Event Description");
        eventDetailsDto1.setEventId(123);
        eventDetailsDto1.setEventName("Event Name");
        eventDetailsDto1.setEventVenue("Event Venue");
        eventDetailsDto1.setStartTime("Start Time");
        eventDetailsDto1.setUserEmail("jane.doe@example.org");
        eventDetailsDto1.setUserName("janedoe");

        ParticipantDetails participantDetails = new ParticipantDetails();
        participantDetails.setEvent(eventDetailsDto1);
        participantDetails.setParticipantID(1);
        participantDetails.setParticipantName("Participant Name");
        participantDetails.setUserAge(1);
        participantDetails.setUserName("janedoe");
        when(participantUtil.toParticipantDetails((Participant) any())).thenReturn(participantDetails);

        EventDetailsDto eventDetailsDto2 = new EventDetailsDto();
        eventDetailsDto2.setEndTime("End Time");
        eventDetailsDto2.setEventAmount(10.0d);
        eventDetailsDto2.setEventCapacity(1);
        eventDetailsDto2.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto2.setEventDescription("Event Description");
        eventDetailsDto2.setEventId(123);
        eventDetailsDto2.setEventName("Event Name");
        eventDetailsDto2.setEventVenue("Event Venue");
        eventDetailsDto2.setStartTime("Start Time");
        eventDetailsDto2.setUserEmail("jane.doe@example.org");
        eventDetailsDto2.setUserName("janedoe");

        AddParticipantDto addParticipantDto = new AddParticipantDto();
        addParticipantDto.setEvent(eventDetailsDto2);
        addParticipantDto.setParticipantName("Participant Name");
        addParticipantDto.setUserAge(1);
        addParticipantDto.setUserName("janedoe");
        assertSame(participantDetails, participantServiceImpl.addParticipant(addParticipantDto));
        verify(participantRepository).existsByParticipantName((String) any());
        verify(participantRepository).save((Participant) any());
        verify(participantUtil).toParticipantDetails((Participant) any());
    }

    /**
     * Method under test: {@link ParticipantServiceImpl#addParticipant(AddParticipantDto)}
     */
    @Test
    void testAddParticipant3() throws ParticipantAreadyExistException {
        EventDetailsDto eventDetailsDto = new EventDetailsDto();
        eventDetailsDto.setEndTime("End Time");
        eventDetailsDto.setEventAmount(10.0d);
        eventDetailsDto.setEventCapacity(1);
        eventDetailsDto.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto.setEventDescription("Event Description");
        eventDetailsDto.setEventId(123);
        eventDetailsDto.setEventName("Event Name");
        eventDetailsDto.setEventVenue("Event Venue");
        eventDetailsDto.setStartTime("Start Time");
        eventDetailsDto.setUserEmail("jane.doe@example.org");
        eventDetailsDto.setUserName("janedoe");

        Participant participant = new Participant();
        participant.setEvent(eventDetailsDto);
        participant.setParticipantID(1);
        participant.setParticipantName("Participant Name");
        participant.setUserAge(1);
        participant.setUserName("janedoe");
        when(participantRepository.existsByParticipantName((String) any())).thenReturn(false);
        when(participantRepository.save((Participant) any())).thenReturn(participant);

        EventDetailsDto eventDetailsDto1 = new EventDetailsDto();
        eventDetailsDto1.setEndTime("End Time");
        eventDetailsDto1.setEventAmount(10.0d);
        eventDetailsDto1.setEventCapacity(1);
        eventDetailsDto1.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto1.setEventDescription("Event Description");
        eventDetailsDto1.setEventId(123);
        eventDetailsDto1.setEventName("Event Name");
        eventDetailsDto1.setEventVenue("Event Venue");
        eventDetailsDto1.setStartTime("Start Time");
        eventDetailsDto1.setUserEmail("jane.doe@example.org");
        eventDetailsDto1.setUserName("janedoe");

        ParticipantDetails participantDetails = new ParticipantDetails();
        participantDetails.setEvent(eventDetailsDto1);
        participantDetails.setParticipantID(1);
        participantDetails.setParticipantName("Participant Name");
        participantDetails.setUserAge(1);
        participantDetails.setUserName("janedoe");
        when(participantUtil.toParticipantDetails((Participant) any())).thenReturn(participantDetails);

        EventDetailsDto eventDetailsDto2 = new EventDetailsDto();
        eventDetailsDto2.setEndTime("End Time");
        eventDetailsDto2.setEventAmount(10.0d);
        eventDetailsDto2.setEventCapacity(1);
        eventDetailsDto2.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto2.setEventDescription("Event Description");
        eventDetailsDto2.setEventId(123);
        eventDetailsDto2.setEventName("Event Name");
        eventDetailsDto2.setEventVenue("Event Venue");
        eventDetailsDto2.setStartTime("Start Time");
        eventDetailsDto2.setUserEmail("jane.doe@example.org");
        eventDetailsDto2.setUserName("janedoe");

        EventDetailsDto eventDetailsDto3 = new EventDetailsDto();
        eventDetailsDto3.setEndTime("End Time");
        eventDetailsDto3.setEventAmount(10.0d);
        eventDetailsDto3.setEventCapacity(1);
        eventDetailsDto3.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto3.setEventDescription("Event Description");
        eventDetailsDto3.setEventId(123);
        eventDetailsDto3.setEventName("Event Name");
        eventDetailsDto3.setEventVenue("Event Venue");
        eventDetailsDto3.setStartTime("Start Time");
        eventDetailsDto3.setUserEmail("jane.doe@example.org");
        eventDetailsDto3.setUserName("janedoe");
        AddParticipantDto addParticipantDto = mock(AddParticipantDto.class);
        when(addParticipantDto.getEvent()).thenReturn(eventDetailsDto3);
        when(addParticipantDto.getUserAge()).thenReturn(1);
        when(addParticipantDto.getParticipantName()).thenReturn("Participant Name");
        when(addParticipantDto.getUserName()).thenReturn("janedoe");
        doNothing().when(addParticipantDto).setEvent((EventDetailsDto) any());
        doNothing().when(addParticipantDto).setParticipantName((String) any());
        doNothing().when(addParticipantDto).setUserAge((Integer) any());
        doNothing().when(addParticipantDto).setUserName((String) any());
        addParticipantDto.setEvent(eventDetailsDto2);
        addParticipantDto.setParticipantName("Participant Name");
        addParticipantDto.setUserAge(1);
        addParticipantDto.setUserName("janedoe");
        assertSame(participantDetails, participantServiceImpl.addParticipant(addParticipantDto));
        verify(participantRepository).existsByParticipantName((String) any());
        verify(participantRepository).save((Participant) any());
        verify(participantUtil).toParticipantDetails((Participant) any());
        verify(addParticipantDto).getEvent();
        verify(addParticipantDto).getUserAge();
        verify(addParticipantDto, atLeast(1)).getParticipantName();
        verify(addParticipantDto).getUserName();
        verify(addParticipantDto).setEvent((EventDetailsDto) any());
        verify(addParticipantDto).setParticipantName((String) any());
        verify(addParticipantDto).setUserAge((Integer) any());
        verify(addParticipantDto).setUserName((String) any());
    }

    /**
     * Method under test: {@link ParticipantServiceImpl#updateParticipantNameByUserName(UpdateParticipantDto)}
     */
    @Test
    void testUpdateParticipantNameByUserName() throws ParticipantNotFoundException {
        EventDetailsDto eventDetailsDto = new EventDetailsDto();
        eventDetailsDto.setEndTime("End Time");
        eventDetailsDto.setEventAmount(10.0d);
        eventDetailsDto.setEventCapacity(1);
        eventDetailsDto.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto.setEventDescription("Event Description");
        eventDetailsDto.setEventId(123);
        eventDetailsDto.setEventName("Event Name");
        eventDetailsDto.setEventVenue("Event Venue");
        eventDetailsDto.setStartTime("Start Time");
        eventDetailsDto.setUserEmail("jane.doe@example.org");
        eventDetailsDto.setUserName("janedoe");

        Participant participant = new Participant();
        participant.setEvent(eventDetailsDto);
        participant.setParticipantID(1);
        participant.setParticipantName("Participant Name");
        participant.setUserAge(1);
        participant.setUserName("janedoe");
        Optional<Participant> ofResult = Optional.of(participant);

        EventDetailsDto eventDetailsDto1 = new EventDetailsDto();
        eventDetailsDto1.setEndTime("End Time");
        eventDetailsDto1.setEventAmount(10.0d);
        eventDetailsDto1.setEventCapacity(1);
        eventDetailsDto1.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto1.setEventDescription("Event Description");
        eventDetailsDto1.setEventId(123);
        eventDetailsDto1.setEventName("Event Name");
        eventDetailsDto1.setEventVenue("Event Venue");
        eventDetailsDto1.setStartTime("Start Time");
        eventDetailsDto1.setUserEmail("jane.doe@example.org");
        eventDetailsDto1.setUserName("janedoe");

        Participant participant1 = new Participant();
        participant1.setEvent(eventDetailsDto1);
        participant1.setParticipantID(1);
        participant1.setParticipantName("Participant Name");
        participant1.setUserAge(1);
        participant1.setUserName("janedoe");
        when(participantRepository.save((Participant) any())).thenReturn(participant1);
        when(participantRepository.findByUserName((String) any())).thenReturn(ofResult);

        EventDetailsDto eventDetailsDto2 = new EventDetailsDto();
        eventDetailsDto2.setEndTime("End Time");
        eventDetailsDto2.setEventAmount(10.0d);
        eventDetailsDto2.setEventCapacity(1);
        eventDetailsDto2.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto2.setEventDescription("Event Description");
        eventDetailsDto2.setEventId(123);
        eventDetailsDto2.setEventName("Event Name");
        eventDetailsDto2.setEventVenue("Event Venue");
        eventDetailsDto2.setStartTime("Start Time");
        eventDetailsDto2.setUserEmail("jane.doe@example.org");
        eventDetailsDto2.setUserName("janedoe");

        ParticipantDetails participantDetails = new ParticipantDetails();
        participantDetails.setEvent(eventDetailsDto2);
        participantDetails.setParticipantID(1);
        participantDetails.setParticipantName("Participant Name");
        participantDetails.setUserAge(1);
        participantDetails.setUserName("janedoe");
        when(participantUtil.toParticipantDetails((Participant) any())).thenReturn(participantDetails);

        UpdateParticipantDto updateParticipantDto = new UpdateParticipantDto();
        updateParticipantDto.setParticipantName("Participant Name");
        updateParticipantDto.setUserName("janedoe");
        assertSame(participantDetails, participantServiceImpl.updateParticipantNameByUserName(updateParticipantDto));
        verify(participantRepository).save((Participant) any());
        verify(participantRepository).findByUserName((String) any());
        verify(participantUtil).toParticipantDetails((Participant) any());
    }


    /**
     * Method under test: {@link ParticipantServiceImpl#updateParticipantNameByUserName(UpdateParticipantDto)}
     */
    @Test
    void testUpdateParticipantNameByUserName3() throws ParticipantNotFoundException {
        EventDetailsDto eventDetailsDto = new EventDetailsDto();
        eventDetailsDto.setEndTime("End Time");
        eventDetailsDto.setEventAmount(10.0d);
        eventDetailsDto.setEventCapacity(1);
        eventDetailsDto.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto.setEventDescription("Event Description");
        eventDetailsDto.setEventId(123);
        eventDetailsDto.setEventName("Event Name");
        eventDetailsDto.setEventVenue("Event Venue");
        eventDetailsDto.setStartTime("Start Time");
        eventDetailsDto.setUserEmail("jane.doe@example.org");
        eventDetailsDto.setUserName("janedoe");
        Participant participant = mock(Participant.class);
        doNothing().when(participant).setEvent((EventDetailsDto) any());
        doNothing().when(participant).setParticipantID(anyInt());
        doNothing().when(participant).setParticipantName((String) any());
        doNothing().when(participant).setUserAge((Integer) any());
        doNothing().when(participant).setUserName((String) any());
        participant.setEvent(eventDetailsDto);
        participant.setParticipantID(1);
        participant.setParticipantName("Participant Name");
        participant.setUserAge(1);
        participant.setUserName("janedoe");
        Optional<Participant> ofResult = Optional.of(participant);

        EventDetailsDto eventDetailsDto1 = new EventDetailsDto();
        eventDetailsDto1.setEndTime("End Time");
        eventDetailsDto1.setEventAmount(10.0d);
        eventDetailsDto1.setEventCapacity(1);
        eventDetailsDto1.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto1.setEventDescription("Event Description");
        eventDetailsDto1.setEventId(123);
        eventDetailsDto1.setEventName("Event Name");
        eventDetailsDto1.setEventVenue("Event Venue");
        eventDetailsDto1.setStartTime("Start Time");
        eventDetailsDto1.setUserEmail("jane.doe@example.org");
        eventDetailsDto1.setUserName("janedoe");

        Participant participant1 = new Participant();
        participant1.setEvent(eventDetailsDto1);
        participant1.setParticipantID(1);
        participant1.setParticipantName("Participant Name");
        participant1.setUserAge(1);
        participant1.setUserName("janedoe");
        when(participantRepository.save((Participant) any())).thenReturn(participant1);
        when(participantRepository.findByUserName((String) any())).thenReturn(ofResult);

        EventDetailsDto eventDetailsDto2 = new EventDetailsDto();
        eventDetailsDto2.setEndTime("End Time");
        eventDetailsDto2.setEventAmount(10.0d);
        eventDetailsDto2.setEventCapacity(1);
        eventDetailsDto2.setEventDate(LocalDate.ofEpochDay(1L));
        eventDetailsDto2.setEventDescription("Event Description");
        eventDetailsDto2.setEventId(123);
        eventDetailsDto2.setEventName("Event Name");
        eventDetailsDto2.setEventVenue("Event Venue");
        eventDetailsDto2.setStartTime("Start Time");
        eventDetailsDto2.setUserEmail("jane.doe@example.org");
        eventDetailsDto2.setUserName("janedoe");

        ParticipantDetails participantDetails = new ParticipantDetails();
        participantDetails.setEvent(eventDetailsDto2);
        participantDetails.setParticipantID(1);
        participantDetails.setParticipantName("Participant Name");
        participantDetails.setUserAge(1);
        participantDetails.setUserName("janedoe");
        when(participantUtil.toParticipantDetails((Participant) any())).thenReturn(participantDetails);

        UpdateParticipantDto updateParticipantDto = new UpdateParticipantDto();
        updateParticipantDto.setParticipantName("Participant Name");
        updateParticipantDto.setUserName("janedoe");
        assertSame(participantDetails, participantServiceImpl.updateParticipantNameByUserName(updateParticipantDto));
        verify(participantRepository).save((Participant) any());
        verify(participantRepository).findByUserName((String) any());
        verify(participant).setEvent((EventDetailsDto) any());
        verify(participant).setParticipantID(anyInt());
        verify(participant, atLeast(1)).setParticipantName((String) any());
        verify(participant).setUserAge((Integer) any());
        verify(participant, atLeast(1)).setUserName((String) any());
        verify(participantUtil).toParticipantDetails((Participant) any());
    }
}

