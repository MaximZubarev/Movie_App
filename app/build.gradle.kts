plugins {
    id("com.android.application")
    id("kotlin-android")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.mldz.movieapp"
        minSdk = 24
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    namespace = "com.mldz.movieapp"
}

dependencies {

    implementation(project(path = ":module_injector"))
    implementation(project(path = ":core_network_api"))
    implementation(project(path = ":core_network_impl"))
    implementation(project(path = ":core_design"))
    implementation(project(path = ":feature_api"))
    implementation(project(path = ":feature_main_impl"))
    implementation(project(path = ":feature_main_api"))
    implementation(libs.coreKtx)
    implementation(libs.bundles.lifecycle)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.coroutine)
    // UI
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.bundles.compose)
    implementation(libs.coil)
    // Navigation
    implementation(libs.navigation)
}