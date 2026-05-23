plugins {
    // Use version-catalog aliases declared in gradle/libs.versions.toml
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.dependency.management)
    `java`
}

group = "com.gwuy.sweeto"
version = "0.0.1-SNAPSHOT"
description = "api"

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
    implementation(project(":infra"))

    // Spring Web starter (version managed by Spring Boot BOM via dependency-management plugin)
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Common: add validation, security, openapi etc as needed:
    implementation("org.springframework.boot:spring-boot-starter-validation")
    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
