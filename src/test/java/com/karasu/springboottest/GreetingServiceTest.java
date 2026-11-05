package com.karasu.springboottest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingServiceTest {

    private final GreetingService service = new GreetingService();

    @Test
    void createsHelloGreeting() {
        assertThat(service.hello("Warren"))
                .isEqualTo(new GreetingResponse("Hello Warren"));
    }

    @Test
    void createsByeGreeting() {
        assertThat(service.bye("Warren"))
                .isEqualTo(new GreetingResponse("Bye Warren"));
    }
}
