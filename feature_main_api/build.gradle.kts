plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mldz.feature_main_api"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
    }
}

dependencies {

    implementation(project(path = ":module_injector"))
    implementation(project(path = ":feature_api"))
    implementation(libs.coreKtx)
}