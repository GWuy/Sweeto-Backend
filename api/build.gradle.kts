plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.jib)
}

dependencies {
    implementation(project(":core"))
    implementation(project(":infra"))

    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.common.library)
    implementation(libs.lombok)
    implementation(libs.mapstruct)

    // Test
    testImplementation(libs.spring.boot.starter.test)
}
