=package com.achala.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.achala.test.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HelloControllerTest {

    @Mock
    private HelloService helloService;

    @InjectMocks
    private HelloController helloController;

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
        String actualGreeting = helloController.sayHello();

        // Assert
        assertEquals(expectedGreeting, actualGreeting);
        verify(helloService).getGreeting();
    }
}