plugins {
    `java`
    // Declare plugin aliases but don't apply them here.
    // Modules that need Spring Boot should use alias(libs.plugins.spring-boot) in their own build file.
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.dependency.management) apply false
}

group = "com.gwuy"
version = "0.0.1-SNAPSHOT"
description = "sweeto"

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

subprojects {
    // Apply only java and dependency-management (dependency-management is safe: it only imports BOMs, it does not add Spring runtime)
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    // Use Java 21 toolchain for every module
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.addAll(listOf("-parameters", "-Xlint:unchecked", "-Xlint:deprecation"))
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    // By default enable normal JAR for libraries
    tasks.named("jar") {
        enabled = true
    }

    // If a module later applies the Spring Boot plugin, 'bootJar' will be provided by that plugin.
    // Do not enable/disable bootJar here globally to avoid affecting non-spring modules.
}
