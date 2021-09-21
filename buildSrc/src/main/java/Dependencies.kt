import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.project
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

const val ktlintVersion = "0.42.0"
const val kotlinVersion = "1.5.31"

object Sdk {
    const val MIN_SDK_VERSION = 26
    const val TARGET_SDK_VERSION = 31
    const val COMPILE_SDK_VERSION = 31
}

object Versions {
    const val KOTLIN_VERSION = "1.5.31"
    const val CORE_KTX = "1.6.0"
    const val KTLINT = "0.42.0"
    const val coroutinesVersion = "1.5.2"
    const val materialVersion = "1.3.0"
    const val rxAndroidVersion = "2.1.0"
    const val rxJavaVersion = "2.1.1"
}

object BuildPluginsVersion {
    const val DETEKT = "1.17.1"
    const val KTLINT = "10.1.0"
    const val VERSIONS_PLUGIN = "0.39.0"
}

object Mvi {
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
}

object Androidx {
    const val appCompat = "androidx.appcompat:appcompat:1.4.0-alpha03"
    const val coreKtx = "androidx.core:core-ktx:1.7.0-beta01"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.0"
    const val material = "com.google.android.material:material:1.5.0-alpha03"
    const val activityCompose = "androidx.activity:activity-compose:1.4.0-alpha02"
}

object Lifecycle {
    private const val version = "2.4.0-beta01"

    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version" // viewModelScope
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version" // lifecycleScope
    const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
}

object Kotlin {
    const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
}

object Jetbrains {
    private const val version = "1.5.2"

    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
}

object DaggerHilt {
    const val version = "2.38.1"
    const val android = "com.google.dagger:hilt-android:$version"
    const val core = "com.google.dagger:hilt-core:$version"
    const val compiler = "com.google.dagger:hilt-compiler:$version"
}

object Accompanist {
    private const val version = "0.15.0"
    const val coil = "com.google.accompanist:accompanist-coil:$version"
    const val swiperefresh = "com.google.accompanist:accompanist-swiperefresh:$version"
}

object Compose {
    const val version = "1.1.0-alpha04"
    const val layout = "androidx.compose.foundation:foundation-layout:$version"
    const val foundation = "androidx.compose.foundation:foundation:$version"
    const val ui = "androidx.compose.ui:ui:$version"
    const val material = "androidx.compose.material:material:$version"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
    const val runtime = "androidx.compose.runtime:runtime:$version"
    const val tooling = "androidx.compose.ui:ui-tooling:$version"
}

inline val DependencyHandler.mvi get() = project(":mvi")
inline val DependencyHandler.uiComponents get() = project(":ui-components")
fun DependencyHandler.implementationCompose() {
    arrayOf(
        Androidx.activityCompose,
        Lifecycle.viewModelCompose,
        Compose.layout,
        Compose.foundation,
        Compose.ui,
        Compose.material,
        Compose.materialIconsExtended,
        Compose.runtime,
    ).forEach { add("implementation", it) }

    add("debugImplementation", Compose.tooling)
    add("debugImplementation", Kotlin.reflect)
}
private typealias PDsS = PluginDependenciesSpec
private typealias PDS = PluginDependencySpec

inline val PDsS.androidApplication: PDS get() = id("com.android.application")
inline val PDsS.androidLib: PDS get() = id("com.android.library")
inline val PDsS.kotlinAndroid: PDS get() = kotlin("android")
inline val PDsS.kotlin: PDS get() = kotlin("jvm")
inline val PDsS.kotlinKapt: PDS get() = kotlin("kapt")
inline val PDsS.daggerHiltAndroid: PDS get() = id("dagger.hilt.android.plugin")
