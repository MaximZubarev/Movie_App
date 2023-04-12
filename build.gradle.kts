// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply{
        set("kotlin_version", "1.8.10")
        set("lifecycle_version", "2.5.1")
        set("room_version", "2.5.0")
        set("coroutine_version", "1.6.0")
        set("dagger_version", "2.45")
        set("hilt_version", "2.45")
        set("okhttp_version", "4.10.0")
        set("retrofit_version", "2.9.0")
        set("ser_converter_version", "0.8.0")
        set("gson_converter_version", "2.6.0")
        set("gson_version", "2.9.0")
        set("nav_version", "2.5.3")
    }
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra.get("kotlin_version") as String}")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath("org.jetbrains.kotlin:kotlin-serialization:${rootProject.extra.get("kotlin_version") as String}")
//        classpath("com.google.dagger:hilt-android-gradle-plugin:${rootProject.extra.get("kotlin_version") as String}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}