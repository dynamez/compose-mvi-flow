import org.gradle.api.JavaVersion

object MviDependencies {

    const val androidMinSdkVersion = 21

    //Tools Version
    const val kotlinVersion = "1.5.30"
    val javaVersion = JavaVersion.VERSION_1_8

    // Versions
    const val coroutinesVersion = "1.5.2"
    const val materialVersion = "1.3.0"
    const val rxAndroidVersion = "2.1.0"
    const val rxJavaVersion = "2.1.1"

    // Testing Versions
    const val jUnitVersion = "4.13.2"

    // Dependencies
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:$rxAndroidVersion"
    const val rxJava = "io.reactivex.rxjava2:rxjava:$rxJavaVersion"

    // Testing Dependencies
    const val jUnit = "junit:junit:$jUnitVersion"
}