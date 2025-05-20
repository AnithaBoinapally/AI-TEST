=package com.achala.test.controller;

import com.achala.test.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class HelloControllerTest {

    @Mock
    private HelloService helloService;

    @InjectMocks
    private HelloController helloController;

    @BeforeEach
    public void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSayHello() {
        // Arrange
        String expectedGreeting = "Hello, World!";
        when(helloService.getGreeting()).thenReturn(expectedGreeting);
        
        // Act
        String actualGreeting = helloController.sayHello();
        
        // Assert
        assertEquals(expectedGreeting, actualGreeting);
    }
}