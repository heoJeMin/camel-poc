package com.airpremia.camelpoc.route

import org.apache.camel.builder.endpoint.EndpointRouteBuilder
import org.springframework.stereotype.Component

@Component
class TimerExample : EndpointRouteBuilder() {
    override fun configure() {
        from(
            timer("timerExample")
                .period(5000)
        )
            .routeId("timerExample")
            .log("timerExample")
    }
}
