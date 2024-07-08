package com.airpremia.camelpoc.route

import org.apache.camel.builder.endpoint.EndpointRouteBuilder
import org.springframework.stereotype.Component

@Component
class SftpExample : EndpointRouteBuilder() {
    override fun configure() {
        from(
            sftp("localhost:22")
                .username("user")
                .password("password")
                .delete(true)
                .delay(5000)
                .binary(true)
                .include(".*.txt")
                .exclude(".*.bak")
                .antInclude("*.txt")
                .antExclude("*.bak")
                .filter { it.endpointPath.endsWith(".txt") }
                .sortBy("file:modified")
                .maxMessagesPerPoll(10)
        ).routeId("sftpExample").to("direct:hello")
    }
}
