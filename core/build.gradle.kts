// Pure domain module – no Spring runtime dependency.
// Contains: entities, value objects, enums, domain interfaces, exceptions.
// Add domain-level dependencies here as needed, e.g.:
//   implementation(libs.mapstruct)
//   compileOnly(libs.lombok)
//   annotationProcessor(libs.lombok)
//   annotationProcessor(libs.mapstruct.processor)

dependencies {
    implementation(libs.lombok)
}