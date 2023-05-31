plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.mldz.core_utils"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    implementation(project(path = ":module_injector"))
    implementation(libs.coreKtx)
    implementation(libs.kotlin.reflect)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.compose.ui)
    implementation(libs.compose.viemodel)
    implementation(libs.compose.animation)
    implementation(libs.compose.foundation)
}