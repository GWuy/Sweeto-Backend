dependencies {
    implementation(project(":core"))

    // Spring Data JPA (version managed by BOM)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.lombok)
    implementation(libs.postgresql)
    implementation(libs.common.library)
}
