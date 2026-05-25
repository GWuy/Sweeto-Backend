plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("java")
}

dependencies {
    // Project dependencies
    implementation(project(":api"))
    implementation(project(":infra"))
    implementation(project(":core"))

    // Custom Libraries - common across all modules
    implementation(libs.bundles.custom.libraries)

    // Spring Boot dependencies
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.spring.boot.starter.data.jpa)

    // Lombok
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}

tasks.jar {
    enabled = false
}

tasks.bootJar {
    enabled = true
    archiveFileName.set("sweeto_hrm.jar")
}

springBoot {
    mainClass.set("com.intern.hub.auth.app.AuthServiceApplication")
}