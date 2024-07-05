package com.airpremia.camelpoc.route

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

@Component
class RestExample : RouteBuilder() {
    //implementation("org.apache.camel:camel-jetty:$camelVersion")
    //implementation("org.apache.camel.springboot:camel-rest-starter:$camelVersion")

    override fun configure() {
        restConfiguration().component("jetty").port(80)

        rest("/api")
            .get("/hello").routeId("restExample")
            .to("direct:hello")

        from("direct:hello").log("Hello World").setBody { "Hello World" }
    }
}
