plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
}

android {
    namespace = "com.mldz.core_network_api"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
    }
}

dependencies {

    implementation(project(path = ":module_injector"))
    implementation(libs.coreKtx)
    implementation(libs.network.kotlin.serialization)
}