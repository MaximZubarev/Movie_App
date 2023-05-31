plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.mldz.feature_main_impl"
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

    implementation(project(path = ":module_injector"))
    implementation(project(path = ":core_network_api"))
    implementation(project(path = ":core_design"))
    implementation(project(path = ":core_utils"))
    implementation(project(path = ":feature_api"))
    implementation(project(path = ":feature_main_api"))
    implementation(libs.coreKtx)
    implementation(libs.bundles.network)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.navigation)
    implementation(libs.bundles.compose)
    implementation(libs.coil)
    implementation(libs.compose.viemodel)
    implementation(libs.compose.tooling.preview)
    debugImplementation(libs.compose.tooling)
}