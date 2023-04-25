/**
 * Precompiled [base-kotlin-convention.gradle.kts][Base_kotlin_convention_gradle] script plugin.
 *
 * @see Base_kotlin_convention_gradle
 */
class BaseKotlinConventionPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Base_kotlin_convention_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
