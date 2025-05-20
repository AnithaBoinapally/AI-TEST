package com.achala.test.controller;

import com.achala.test.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WorldControllerTest {

    @InjectMocks
    private WorldController worldController;

    @Mock
    private HelloService helloService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSayHello() {
        // Arrange
        String expectedGreeting = "Hello, World!";
        when(helloService.getGreeting()).thenReturn(expectedGreeting);

        // Act
        String actualGreeting = worldController.sayHello();

        // Assert
        assertEquals(expectedGreeting, actualGreeting, "The greeting should match the expected string");
    }
}