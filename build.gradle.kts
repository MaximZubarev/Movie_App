// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.androidGradle)
        classpath(libs.secrets.gradlePlugin)
        classpath(libs.kotlinGradle)
        classpath(libs.kotlin.serialization)
    }
}

ext {
    var compileSdkVersion = 33
    var minSdkVersion = 24
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}