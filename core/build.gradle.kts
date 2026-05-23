plugins {
    `java`
}

group = "com.gwuy.sweeto"
version = "0.0.1-SNAPSHOT"
description = "core"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Core không phụ thuộc Spring Boot; giữ dependencies nhẹ.
    // Thêm libraries thuần Java hoặc utility libs ở đây nếu cần.
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
