rootProject.name = "sweeto"

pluginManagement {
    // Các repository để tải plugin (Gradle Plugin Portal, Maven Central, jitpack)
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }

    // Dùng version catalog (gradle/libs.versions.toml) cho plugin aliases
    // (Gradle tự liên kết alias(libs.plugins.xxx) với plugin definitions ở libs.versions.toml)
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        mavenLocal()
    }
}

include(
    "api",
    "core",
    "infra"
)
