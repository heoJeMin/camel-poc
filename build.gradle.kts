plugins {
    id("org.springframework.boot") version "3.2.7"
    id("io.spring.dependency-management") version "1.1.5"
    kotlin("plugin.jpa") version "1.9.24"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
}

group = "com.airpremia"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

val camelVersion = "4.6.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.apache.camel.springboot:camel-spring-boot-starter:$camelVersion")

    implementation("org.apache.camel.springboot:camel-componentdsl-starter:$camelVersion")
    implementation("org.apache.camel.springboot:camel-endpointdsl-starter:$camelVersion")

    implementation("org.apache.camel.springboot:camel-rest-starter:$camelVersion")
    implementation("org.apache.camel:camel-jetty:$camelVersion")

    implementation("org.apache.camel.springboot:camel-cron-starter:$camelVersion")

    implementation("org.apache.camel.springboot:camel-debezium-mysql-starter:$camelVersion")
    implementation("org.apache.camel:camel-debezium-mysql:$camelVersion")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
