=package com.achala.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.achala.test.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @BeforeEach
    public void setUp() {
        // Setup any common behavior or initialization if needed
    }

    @Test
    public void testSayHello() throws Exception {
        // Arrange
        String expectedGreeting = "Hello, World!";
        when(helloService.getGreeting()).thenReturn(expectedGreeting);

        // Act & Assert
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedGreeting));
    }

    @Test
    public void testSayHelloWithDifferentGreeting() throws Exception {
        // Arrange
        String expectedGreeting = "Hi there!";
        when(helloService.getGreeting()).thenReturn(expectedGreeting);

        // Act & Assert
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedGreeting));
    }
}