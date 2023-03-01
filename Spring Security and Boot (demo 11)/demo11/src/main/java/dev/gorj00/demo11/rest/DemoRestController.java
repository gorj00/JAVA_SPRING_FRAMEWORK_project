package dev.gorj00.demo11.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    @GetMapping("/")
    public String home() {
        return "Welcome Home";
    }

    @GetMapping("/user")
    public String homeUser() {
        return "Welcome User";
    }

    @GetMapping("/admin")
    public String homeAdmin() {
        return "Welcome Admin";
    }

}
