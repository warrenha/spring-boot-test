package com.karasu.springboottest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public GreetingResponse hello(@RequestParam(defaultValue = "World") String name) {
        return greetingService.hello(name);
    }

    @GetMapping("/bye")
    public GreetingResponse bye(@RequestParam(defaultValue = "World") String name) {
        return greetingService.bye(name);
    }
}
