package com.stackroute.userauthenticationmanagement.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.userauthenticationmanagement.models.User;
import com.stackroute.userauthenticationmanagement.repository.RoleRepository;
import com.stackroute.userauthenticationmanagement.repository.UserRepository;
import com.stackroute.userauthenticationmanagement.request.SignUpRequest;
import com.stackroute.userauthenticationmanagement.request.SigninRequest;
import com.stackroute.userauthenticationmanagement.security.Jwt.JwtUtils;
import com.stackroute.userauthenticationmanagement.security.services.UserDetailsImpl;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthController.class})
@ExtendWith(SpringExtension.class)
class AuthControllerTest {
    @Autowired
    private AuthController authController;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtUtils jwtUtils;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;


    @Test
    void testAuthenticateUser() throws Exception {
        when(jwtUtils.generateJwtToken(any())).thenReturn("ABC123");
        when(authenticationManager.authenticate(any())).thenReturn(new TestingAuthenticationToken(
                new UserDetailsImpl(123L, "Saurabh.Jha", "saurabh.jha@globallogic.com", "saurabh", "8912314156", new ArrayList<>()),
                "Credentials"));

        SigninRequest signinRequest = new SigninRequest();
        signinRequest.setPassword("saurabh");
        signinRequest.setUsername("Saurabh.Jha");
        String content = (new ObjectMapper()).writeValueAsString(signinRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"token\":\"ABC123\",\"type\":\"Bearer\",\"id\":123,\"username\":\"Saurabh.Jha\",\"email\":\"saurabh.jha@globallogic.com\",\"phone"
                                        + "\":\"8912314156\",\"roles\":[]}"));
    }





    @Test
    void testRegisterUser() throws Exception {
        User user = new User();
        user.setEmail("saurabh.jha@globallogic.com");
        user.setId(123L);
        user.setPassword("saurabh");
        user.setPhone("8912314156");
        user.setRoles(new HashSet<>());
        user.setUsername("Saurabh.Jha");
        when(userRepository.existsByEmail(any())).thenReturn(true);
        when(userRepository.existsByUsername(any())).thenReturn(true);
        when(userRepository.save(any())).thenReturn(user);

        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setEmail("saurabh.jha@globallogic.com");
        signUpRequest.setPassword("saurabh");
        signUpRequest.setPhone("8912314156");
        signUpRequest.setRole(new HashSet<>());
        signUpRequest.setUsername("Saurabh.Jha");
        String content = (new ObjectMapper()).writeValueAsString(signUpRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Error: Username is already taken!\"}"));
    }


    @Test
    void testRegisterUser2() throws Exception {
        User user = new User();
        user.setEmail("saurabh.jha@globallogic.com");
        user.setId(123L);
        user.setPassword("saurabh");
        user.setPhone("8912314156");
        user.setRoles(new HashSet<>());
        user.setUsername("Saurabh.Jha");
        when(userRepository.existsByEmail(any())).thenReturn(true);
        when(userRepository.existsByUsername(any())).thenReturn(false);
        when(userRepository.save(any())).thenReturn(user);

        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setEmail("saurabh.jha@globallogic.com");
        signUpRequest.setPassword("saurabh");
        signUpRequest.setPhone("8912314156");
        signUpRequest.setRole(new HashSet<>());
        signUpRequest.setUsername("Saurabh.Jha");
        String content = (new ObjectMapper()).writeValueAsString(signUpRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Error: Email is already in use!\"}"));
    }
}

