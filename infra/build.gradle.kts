plugins {
    `java`
    // Use dependency-management plugin (imports Spring Boot BOM) so infra can depend on starters without version noise
    alias(libs.plugins.dependency.management)
}

group = "com.gwuy.sweeto"
version = "0.0.1-SNAPSHOT"
description = "infra"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))

    // Use Spring Data JPA and Postgres driver. We do NOT apply the Spring Boot plugin here.
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
