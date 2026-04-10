plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.redcombalarm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.redcombalarm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // For Bottom Navigation
    implementation ("com.google.android.material:material:1.9.0")
// For step detection (Google Activity Recognition)
    implementation ("com.google.android.gms:play-services-location:21.0.1")
// For PatternLock (optional library)
    implementation ("com.andrognito.patternlockview:patternlockview:1.0.0")

}