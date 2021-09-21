plugins {
    androidApplication
    kotlinAndroid
    kotlinKapt
    daggerHiltAndroid
}

hilt {
    enableExperimentalClasspathAggregation = true
}

android {
    compileSdk = Sdk.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = Sdk.MIN_SDK_VERSION
        targetSdk = Sdk.TARGET_SDK_VERSION

        applicationId = "com.rayout.composemviflow"
        versionCode = 100000
            versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = listOf(
            "-P",
            "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
        )
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.version
    }
}

dependencies {
    implementation(
        fileTree(
            mapOf(
                "dir" to "libs",
                "include" to listOf("*.jar")
            )
        )
    )
    implementation(uiComponents)
    implementation(mvi)

    implementationCompose()

    implementation(kotlin("stdlib-jdk7"))
    implementation(Androidx.appCompat)
    implementation(Androidx.coreKtx)

    implementation(Lifecycle.viewModelKtx)
    implementation(Lifecycle.runtimeKtx)

    implementation(Androidx.constraintLayout)
    implementation(Androidx.material)

    implementation(Jetbrains.coroutinesCore)

    implementation(DaggerHilt.android)
    kapt(DaggerHilt.compiler)

    implementation(Accompanist.coil)
    implementation(Accompanist.swiperefresh)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

}