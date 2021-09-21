plugins {
    androidLib
    kotlinAndroid
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
    implementation(Mvi.kotlin)
    implementation(Mvi.coroutinesCore)
    implementation(Mvi.rxJava)
    implementation(Mvi.rxAndroid)
}