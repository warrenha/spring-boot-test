package com.karasu.springboottest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingControllerTest {

    private final GreetingController controller =
            new GreetingController(new GreetingService());

    @Test
    void returnsHelloGreetingForName() {
        assertThat(controller.hello("Warren"))
                .isEqualTo(new GreetingResponse("Hello Warren"));
    }

    @Test
    void returnsByeGreetingForName() {
        assertThat(controller.bye("Warren"))
                .isEqualTo(new GreetingResponse("Bye Warren"));
    }
}
