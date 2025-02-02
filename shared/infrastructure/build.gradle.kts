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
    implementation("org.springframework:spring-context:6.2.1")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.password4j:password4j:1.8.2")
    compileOnly("org.springframework.boot:spring-boot-starter-data-mongodb:3.4.0")
}