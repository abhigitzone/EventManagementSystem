package com.stackroute.participantservice.controller;

import com.stackroute.participantservice.dto.AddParticipantDto;
import com.stackroute.participantservice.dto.ParticipantDetails;
import com.stackroute.participantservice.dto.UpdateParticipantDto;
import com.stackroute.participantservice.exception.ParticipantAreadyExistException;
import com.stackroute.participantservice.exception.ParticipantNotFoundException;
import com.stackroute.participantservice.service.IParticipantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ParticipantcontrollerTest {


        @Mock
       IParticipantService service;
        @InjectMocks
        @Spy
        ParticipantController controller;
        /**
         *saveParticipant for success
         */
        @Test
        void testAddParticipant_1() throws Exception{
            ParticipantDetails response =mock(ParticipantDetails.class);
            AddParticipantDto request=mock(AddParticipantDto.class);
            when(service.addParticipant(request)).thenReturn(response);
            ParticipantDetails result= controller.addParticipant(request).getBody();
            assertEquals(response,result);
            verify(service).addParticipant(request);
        }
        /**
         *save Participant then throw Participant already exist
         */
        @Test
        void testAddParticipant_2() throws Exception{
            ParticipantDetails response =mock(ParticipantDetails.class);
            AddParticipantDto request=mock(AddParticipantDto.class);
            when(service.addParticipant(request)).thenThrow(ParticipantAreadyExistException.class);
            Executable excutable=()->service.addParticipant(request);
            assertThrows(ParticipantAreadyExistException.class,excutable);
        }
        /**
         * update Participant
         * for success status
         */
        @Test
        void testUpdateParticipant_1() throws Exception{
            ParticipantDetails response =mock(ParticipantDetails.class);
            UpdateParticipantDto request=mock(UpdateParticipantDto.class);
            when(service.updateParticipantNameByUserName(request)).thenReturn(response);
            ParticipantDetails result= controller.updateParticipantByUserName(request).getBody();
            assertEquals(response,result);
            verify(service).updateParticipantNameByUserName(request);
        }

        /**
         * update Participant
         * @throws Exception
         */

       @Test
        void testUpdateParticipant_2() throws Exception{
            ParticipantDetails response =mock(ParticipantDetails.class);
            UpdateParticipantDto request=mock(UpdateParticipantDto.class);
            when(service.updateParticipantNameByUserName(request)).thenThrow(ParticipantNotFoundException.class);
            Executable excutable=()->service.updateParticipantNameByUserName(request);
            assertThrows(ParticipantNotFoundException.class,excutable);
        }

        /**
         * delete Participant by id
         * if id is found
         */

        @Test
        void testDeleteParticipant()throws Exception {
            Integer id=1;
            String response="deleted successfully";
            when(service.deleteParticipantById(id)).thenReturn(response);
            String result=controller.deleteParticipantById(id).getBody();
            assertEquals(response,result);
            verify(service).deleteParticipantById(id);

        }

        /**
         * delete Participant
         * @throws Exception
         */

        @Test
        void testDeleteFeedback_2()throws Exception {
            Integer id=1;
            String response="deleted successfully";
            when(service.deleteParticipantById(id)).thenThrow(ParticipantNotFoundException.class);
            Executable excutable=()->service.deleteParticipantById(id);
            assertThrows(ParticipantNotFoundException.class,excutable);
        }


}
