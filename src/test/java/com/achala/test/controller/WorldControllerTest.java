=package com.achala.test.controller;

import com.achala.test.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(WorldController.class) // Tells Spring to only load the WorldController
public class WorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private HelloService helloService;

    @BeforeEach
    void setUp() {
        helloService = Mockito.mock(HelloService.class);
        // You should inject the mocked service into the controller here.
        // To do that, you might need to change the WorldController to allow for the service to be set.
        // Alternatively, you can use @MockBean to create a mock Bean for your tests, as shown below.
    }

    // Use @MockBean to create a mock of HelloService in the Spring context
    @Autowired
    private HelloService mockHelloService;

    @Test
    void testSayHello() throws Exception {
        // Arrange
        String expectedGreeting = "Hello, World!";
        when(mockHelloService.getGreeting()).thenReturn(expectedGreeting);
        
        // Act and Assert
        mockMvc.perform(get("/world")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedGreeting));
    }

    @Test
    void testSayHello_withDifferentGreeting() throws Exception {
        // Arrange
        String expectedGreeting = "Goodbye, World!";
        when(mockHelloService.getGreeting()).thenReturn(expectedGreeting);
        
        // Act and Assert
        mockMvc.perform(get("/world")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedGreeting));
    }
}