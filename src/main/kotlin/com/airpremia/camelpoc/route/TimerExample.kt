package com.airpremia.camelpoc.route

import org.apache.camel.builder.RouteBuilder
import org.apache.camel.builder.endpoint.StaticEndpointBuilders.timer
import org.springframework.stereotype.Component

@Component
class TimerExample : RouteBuilder() {
    override fun configure() {
        from(timer("timerExample").period(5000)).routeId("timerExample").log("timerExample")
    }
}
