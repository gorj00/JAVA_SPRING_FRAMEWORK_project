package dev.gorj00.app.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello Spring Boot Wolrd! Time on server is " + LocalDateTime.now();
    }



}
