
package com.achala.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.achala.test.service.HelloService;

@RestController
public class WorldController {

    private final HelloService helloService;

    // Constructor injection
    public WorldController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/world")
    public String sayHello() {
        return helloService.getGreeting();
    }
}