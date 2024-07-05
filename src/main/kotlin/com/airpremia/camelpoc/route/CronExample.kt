package com.airpremia.camelpoc.route

import org.apache.camel.builder.endpoint.EndpointRouteBuilder
import org.springframework.stereotype.Component

@Component
class CronExample : EndpointRouteBuilder() {
    //implementation("org.apache.camel.springboot:camel-cron-starter:$camelVersion")
    override fun configure() {
        from(
            cron("cronExample")
                .schedule("0/3 * * * * *")
        )
            .routeId("cronExample")
            .log("cronExample")
    }
}
