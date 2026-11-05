package com.karasu.springboottest;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public GreetingResponse hello(String name) {
        return new GreetingResponse("Hello " + name);
    }

    public GreetingResponse bye(String name) {
        return new GreetingResponse("Bye " + name);
    }
}
