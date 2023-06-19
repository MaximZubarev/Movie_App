plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mldz.core_design"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.coreKtx)
}