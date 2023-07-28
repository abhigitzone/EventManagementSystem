package com.stackroute.userauthenticationmanagement.security.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.stackroute.userauthenticationmanagement.models.User;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

class UserDetailsImplTest {

    @Test
    void testBuild() {
        User user = new User();
        user.setEmail("saurabh.jha@globallogic.com");
        user.setId(123L);
        user.setPassword("saurabh");
        user.setPhone("8912314156");
        user.setRoles(new HashSet<>());
        user.setUsername("Saurabh.Jha");
        UserDetailsImpl buildResult = UserDetailsImpl.build(user);

        User user1 = new User();
        user1.setEmail("saurabh.jha@globallogic.com");
        user1.setId(123L);
        user1.setPassword("saurabh");
        user1.setPhone("8912314156");
        user1.setRoles(new HashSet<>());
        user1.setUsername("Saurabh.Jha");
        UserDetailsImpl actualBuildResult = UserDetailsImpl.build(user1);
        assertEquals(buildResult, actualBuildResult);
        assertEquals("saurabh.jha@globallogic.com", actualBuildResult.getEmail());
        assertEquals(123L, actualBuildResult.getId().longValue());
        assertEquals("saurabh", actualBuildResult.getPassword());
        assertEquals("Saurabh.Jha", actualBuildResult.getUsername());
        assertTrue(actualBuildResult.isAccountNonExpired());
        assertTrue(actualBuildResult.isAccountNonLocked());
        assertTrue(actualBuildResult.isCredentialsNonExpired());
        assertTrue(actualBuildResult.isEnabled());
    }
}

