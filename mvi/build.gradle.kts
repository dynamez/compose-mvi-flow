plugins {
    id("com.android.application")
    kotlin("android")
}

val libraryVersion = "2.1.2"
val libraryVersionCode = 6
val packageName = "com.rayout.mvi"
val libraryName = project.name
val releasePath = "$buildDir/outputs/aar/$libraryName-release.aar"

android {

    defaultConfig {
        minSdk = 26
        compileSdk = 31
        versionCode = 201020
        versionName = "2.1.2"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(MviDependencies.kotlin)
    implementation(MviDependencies.coroutinesCore)
    implementation(MviDependencies.rxJava)
    implementation(MviDependencies.rxAndroid)
}