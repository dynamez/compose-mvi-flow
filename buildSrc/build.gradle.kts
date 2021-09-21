plugins {
    `kotlin-dsl`
}
repositories {
    google()
    mavenCentral()
}

object Plugins {
    const val AGP = "7.0.2"
    const val DOKKA = "1.5.0"
    const val KOTLIN = "1.5.30"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Plugins.KOTLIN}")
    implementation("com.android.tools.build:gradle:${Plugins.AGP}")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:${Plugins.DOKKA}")
    implementation("org.jetbrains.dokka:dokka-core:${Plugins.DOKKA}")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:5.15.1")
}
