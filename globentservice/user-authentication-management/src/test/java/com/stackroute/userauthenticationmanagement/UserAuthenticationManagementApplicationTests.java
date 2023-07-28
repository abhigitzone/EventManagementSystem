package com.stackroute.userauthenticationmanagement;

import com.stackroute.userauthenticationmanagement.models.User;
import com.stackroute.userauthenticationmanagement.repository.UserRepository;
import com.stackroute.userauthenticationmanagement.security.services.UserDetailsImpl;
import com.stackroute.userauthenticationmanagement.security.services.UserDetailsServiceImpl;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UserAuthenticationManagementApplicationTests {

//	@Test
//	void contextLoads() {
//	}
//
//    @Mock
//    private UserRepository userRepository;
//    @InjectMocks
//    private UserDetailsServiceImpl userDetailsService;
//    @InjectMocks
//    private UserDetailsImpl userDetails;
//
//    public void userSignupTestValid() throws ExecutionControl.UserException {
//
//        User user=new User();
//        user.setUsername("SJ7");
//        user.setEmail("saurav.jha@yahoo.in");
//        user.setPassword("saurabh");
//        user.setPhone("981234125");
//       // user.setRoles("organiser");
//
//        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(Optional.ofNullable(null));
//        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
//        Assertions.assertEquals("organiser",userDetails.);
//
//    }

}
