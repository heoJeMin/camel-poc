package com.airpremia.camelpoc.route

import org.apache.camel.builder.RouteBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class BeanExample : RouteBuilder() {
    override fun configure() {
        restConfiguration().component("jetty").port(80)

        rest("/bean")
            .get().routeId("beanExample")
            .to("direct:helloBean")

        from("direct:helloBean").bean(HelloBean(), "hello").setBody { "hello Bean" }
    }
}

@Component
class HelloBean {

    @Bean
    fun hello(): String {
        print("Hello Bean")
        return "Hello Bean"
    }
}
