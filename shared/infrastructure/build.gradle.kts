group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

plugins {
    kotlin("jvm") version ("2.0.21")
    kotlin("plugin.spring") version ("2.0.21")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":shared:domain"))
    implementation(project(":domain:core"))
    implementation(project(":domain:application"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")
    implementation("org.apache.kafka:kafka-clients:3.9.0")
    implementation("org.testcontainers:kafka:1.20.4")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.0")
}

tasks.test {
    useJUnitPlatform()
}