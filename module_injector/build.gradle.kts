plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mldz.module_injector"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    implementation(libs.coreKtx)
}