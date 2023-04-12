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

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra.get("kotlin_version") as String}")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.extra.get("coroutine_version") as String}")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${rootProject.extra.get("lifecycle_version") as String}")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${rootProject.extra.get("lifecycle_version") as String}")

    // square
    implementation("com.squareup.okhttp3:okhttp:${rootProject.extra.get("okhttp_version") as String}")
    implementation("com.squareup.retrofit2:retrofit:${rootProject.extra.get("retrofit_version") as String}")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${rootProject.extra.get("ser_converter_version") as String}")
    implementation("com.squareup.retrofit2:converter-gson:${rootProject.extra.get("gson_converter_version") as String}")

    implementation("com.google.code.gson:gson:${rootProject.extra.get("gson_version") as String}")

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.29.1-alpha")

    // coil
    implementation("io.coil-kt:coil-compose:2.2.2")

    // Room
    implementation("androidx.room:room-runtime:${rootProject.extra.get("room_version") as String}")
    implementation("androidx.room:room-ktx:${rootProject.extra.get("room_version") as String}")
    kapt("androidx.room:room-compiler:${rootProject.extra.get("room_version") as String}")

    // Navigation
    implementation("androidx.navigation:navigation-compose:${rootProject.extra.get("nav_version") as String}")

    api("com.google.dagger:dagger:${rootProject.extra.get("dagger_version") as String}")
    kapt("com.google.dagger:dagger-compiler:${rootProject.extra.get("dagger_version") as String}")

    // Integration with activities
    implementation("androidx.activity:activity-compose:1.6.1")
    // Compose Material Design
    implementation("androidx.compose.material:material:1.3.1")
    // Animations
    implementation("androidx.compose.animation:animation:1.3.3")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.3.3")
    // Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.3")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}