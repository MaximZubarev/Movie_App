enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {

    repositories {
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {

    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Movie App"

include(":app")
include(":module_injector")
include(":core_network_api")
include(":core_network_impl")
include(":feature_main_api")
include(":feature_main_impl")
include(":feature_api")
include(":core_design")
include(":core_utils")
