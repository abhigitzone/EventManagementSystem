package com.stackroute.userauthenticationmanagement.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void testConstructor() {
        User actualUser = new User("Saurabh.Jha", "saurabh.jha@globallogic.com", "saurabh", "8912314156");

        assertEquals("saurabh.jha@globallogic.com", actualUser.getEmail());
        assertEquals("Saurabh.Jha", actualUser.getUsername());
        assertTrue(actualUser.getRoles().isEmpty());
        assertEquals("8912314156", actualUser.getPhone());
        assertEquals("saurabh", actualUser.getPassword());
    }
}

