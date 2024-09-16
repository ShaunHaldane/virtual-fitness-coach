package com.shaun.fitness_coach_service;

import com.shaun.fitness_coach_service.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserServiceNotNull() {
        assertNotNull(userService, "UserService should be autowired and not null");
    }
}
