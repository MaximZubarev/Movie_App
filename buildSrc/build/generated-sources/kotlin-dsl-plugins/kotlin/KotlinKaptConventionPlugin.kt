/**
 * Precompiled [kotlin-kapt-convention.gradle.kts][Kotlin_kapt_convention_gradle] script plugin.
 *
 * @see Kotlin_kapt_convention_gradle
 */
class KotlinKaptConventionPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Kotlin_kapt_convention_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
