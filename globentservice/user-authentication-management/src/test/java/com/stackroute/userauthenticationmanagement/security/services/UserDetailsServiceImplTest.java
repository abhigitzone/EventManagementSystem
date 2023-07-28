package com.stackroute.userauthenticationmanagement.security.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.stackroute.userauthenticationmanagement.models.ERole;
import com.stackroute.userauthenticationmanagement.models.Role;
import com.stackroute.userauthenticationmanagement.models.User;
import com.stackroute.userauthenticationmanagement.repository.UserRepository;

import java.util.Collection;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserDetailsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @MockBean
    private UserRepository userRepository;


    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        User user = new User();
        user.setEmail("saurabh.jha@globallogic.com");
        user.setId(123L);
        user.setPassword("saurabh");
        user.setPhone("8912314156");
        user.setRoles(new HashSet<>());
        user.setUsername("Saurabh.Jha");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername(any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = userDetailsServiceImpl.loadUserByUsername("Saurabh.Jha");
        assertTrue(actualLoadUserByUsernameResult.getAuthorities().isEmpty());
        assertEquals("Saurabh.Jha", actualLoadUserByUsernameResult.getUsername());
        assertEquals("8912314156", ((UserDetailsImpl) actualLoadUserByUsernameResult).getPhone());
        assertEquals("saurabh", actualLoadUserByUsernameResult.getPassword());
        assertEquals(123L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getId().longValue());
        assertEquals("saurabh.jha@globallogic.com", ((UserDetailsImpl) actualLoadUserByUsernameResult).getEmail());
        verify(userRepository).findByUsername(any());
    }


    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        Role role = new Role();
        role.setId(1);
        role.setName(ERole.ROLE_PARTICIPANT);

        HashSet<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        User user = new User();
        user.setEmail("saurabh.jha@globallogic.com");
        user.setId(123L);
        user.setPassword("saurabh");
        user.setPhone("8912314156");
        user.setRoles(roleSet);
        user.setUsername("Saurabh.Jha");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername(any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = userDetailsServiceImpl.loadUserByUsername("Saurabh.Jha");
        Collection<? extends GrantedAuthority> authorities = actualLoadUserByUsernameResult.getAuthorities();
        assertEquals(1, authorities.size());
        assertEquals("saurabh.jha@globallogic.com", ((UserDetailsImpl) actualLoadUserByUsernameResult).getEmail());
        assertEquals("saurabh", actualLoadUserByUsernameResult.getPassword());
        assertEquals("Saurabh.Jha", actualLoadUserByUsernameResult.getUsername());
        assertEquals("8912314156", ((UserDetailsImpl) actualLoadUserByUsernameResult).getPhone());
        assertEquals(123L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getId().longValue());
        assertEquals("ROLE_PARTICIPANT", ((List<? extends GrantedAuthority>) authorities).get(0).getAuthority());
        verify(userRepository).findByUsername(any());
    }





    @Test
    void testLoadUserByUsername4() throws UsernameNotFoundException {
        when(userRepository.findByUsername(any())).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> userDetailsServiceImpl.loadUserByUsername("Saurabh.Jha"));
        verify(userRepository).findByUsername(any());
    }


    @Test
    void testLoadUserByUsername5() throws UsernameNotFoundException {
        when(userRepository.findByUsername(any())).thenThrow(new UsernameNotFoundException("Msg"));
        assertThrows(UsernameNotFoundException.class, () -> userDetailsServiceImpl.loadUserByUsername("Saurabh.Jha"));
        verify(userRepository).findByUsername(any());
    }



}



