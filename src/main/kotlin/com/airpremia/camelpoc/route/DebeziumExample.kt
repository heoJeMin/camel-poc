package com.airpremia.camelpoc.route

import org.apache.camel.LoggingLevel
import org.apache.camel.builder.RouteBuilder

//@Component
class DebeziumExample : RouteBuilder() {
    override fun configure() {
//        implementation("org.apache.camel.springboot:camel-debezium-mysql-starter:$camelVersion")
//        implementation("org.apache.camel:camel-debezium-mysql:$camelVersion")
//        implementation("com.mysql:mysql-connector-j")

        /*
        kafka와 같이 사용해야 함.
         */
        onException(Exception::class.java)
            .log(LoggingLevel.ERROR, "데이터베이스 연결 실패: \${exception.message}")

        from(
            "debezium-mysql:debezium-router-name" +
                    "?offsetStorageFileName=/offset.dat" +
                    "&topicPrefix=prefix" +
                    "&databaseHostname=localhost" +
                    "&databaseUser=local_user" +
                    "&databasePassword=1234" +
                    "&databaseIncludeList=job_db" +
                    "&databaseServerId=1" +
                    "&tableIncludeList=job_db.bbs_bdoc_tb"
        )
            .log(LoggingLevel.INFO, "데이터베이스 연결 시도 중...")
            .process {
                print(it.`in`.getBody(String::class.java))
            }
            .log(LoggingLevel.INFO, "데이터베이스 연결 및 데이터 처리 완료")
            .routeId("debeziumExample")
    }
}
