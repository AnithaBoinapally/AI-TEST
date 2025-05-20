package com.achala.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.achala.test.service.HelloService;

@RestController
public class HelloController {

    private final HelloService helloService;

    // Constructor injection
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String sayHello() {
    	System.out.println("anitha...");
        return helloService.getGreeting();
    }
}