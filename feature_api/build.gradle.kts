plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mldz.feature_api"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    implementation(libs.navigation)
    implementation(libs.compose.ui)
}