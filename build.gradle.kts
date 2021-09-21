object Plugins {
    const val AGP = "7.0.2"
    const val DOKKA = "1.5.0"
    const val KOTLIN = "1.5.31"
}
buildscript {

    repositories {
        google()
        mavenCentral()
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
        gradlePluginPortal()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:1.5.0")
        classpath("org.jetbrains.dokka:dokka-core:1.5.0")
        classpath("com.diffplug.spotless:spotless-plugin-gradle:5.15.1")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
    }
}

//plugins {
//    id("com.android.application") apply false
//    id("com.android.library") apply false
//    kotlin("android") apply false
//    id("io.gitlab.arturbosch.detekt") version BuildPluginsVersion.DETEKT
//    id("org.jlleitschuh.gradle.ktlint") version BuildPluginsVersion.KTLINT
//    id("com.github.ben-manes.versions") version BuildPluginsVersion.VERSIONS_PLUGIN
//}

allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
            sourceCompatibility = JavaVersion.VERSION_11.toString()
            targetCompatibility = JavaVersion.VERSION_11.toString()

            useIR = true
            // Opt-in to experimental compose APIs
            freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
            // Enable experimental coroutines APIs, including collectAsState()
            freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
        }
    }

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
    }
}

subprojects {
    apply {
        plugin("com.diffplug.spotless")
    }

    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        kotlin {
            target("**/*.kt")

            ktlint(Versions.KTLINT).userData(
                // TODO this should all come from editorconfig https://github.com/diffplug/spotless/issues/142
                kotlin.collections.mapOf(
                    "indent_size" to "2",
                    "kotlin_imports_layout" to "ascii"
                )
            )

            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }

        format("xml") {
            target("**/res/**/*.xml")

            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }

        kotlinGradle {
            target("**/*.gradle.kts", "*.gradle.kts")

            ktlint(Versions.KTLINT).userData(
                kotlin.collections.mapOf(
                    "indent_size" to "2",
                    "kotlin_imports_layout" to "ascii"
                )
            )

            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }
    }
}

tasks {
    register("clean", Delete::class.java) {
        delete(rootProject.buildDir)
    }
}
