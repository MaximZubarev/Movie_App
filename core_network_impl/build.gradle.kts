plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.mldz.core_network_impl"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
    }
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {

    implementation(project(path = ":core_network_api"))
    implementation(project(path = ":module_injector"))
    implementation(libs.coreKtx)
    implementation(libs.bundles.network)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}