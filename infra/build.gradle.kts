dependencies {
    implementation(project(":core"))

    // Spring Data JPA (version managed by BOM)
    implementation(libs.spring.boot.starter.data.jpa)

    // PostgreSQL driver – runtime only, not needed at compile time
    runtimeOnly(libs.postgresql)
}
