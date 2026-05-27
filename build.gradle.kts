plugins {
    java
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.dependency.management) apply false
    alias(libs.plugins.jib) apply false
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    group = "com.gwuy.sweeto_auth"
    version = "1.0.0"

    // Import Spring Boot BOM for version management across all modules.
    // This does NOT add any Spring runtime; it only pins dependency versions.
    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(25))
        }
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.addAll(
            listOf(
                "-parameters",
                "-Xlint:unchecked",
                "-Xlint:deprecation"
            )
        )
    }

    // Compatibility task for IDE/Tooling API Kotlin DSL model requests.
    // Newer Gradle versions may not provide `prepareKotlinBuildScriptModel` by default,
    // but some IDE sync flows still try to invoke it on each module.
    tasks.register("prepareKotlinBuildScriptModel") {
        group = "help"
        description = "Compatibility no-op for IDE Kotlin DSL import"
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    tasks.test {
        useJUnitPlatform()
    }
}
