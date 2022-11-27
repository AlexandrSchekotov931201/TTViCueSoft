package ru.apshheko.buildsrc

import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies

fun Project.dependencies(
    compose: Boolean = false,
    glide: Boolean = false,
    implementations: List<List<String>>? = null,
    testImplementations: List<List<String>>? = null,
    androidTestImplementations: List<List<String>>? = null,
    modules: List<String>? = null
) {
    dependencies {
        implementationsGlide(glide)
        implementationsCompose(compose)
        implementationsDagger()
        implementations?.forEach { implementations(it) }
        testImplementations?.forEach { testImplementations(it) }
        androidTestImplementations?.forEach { androidTestImplementations(it) }
        modules?.forEach { modulesDep(it) }
    }
}

private fun DependencyHandler.implementationsCompose(isNeed: Boolean) {
    if (isNeed) {
        implementation(platform(Libs.Compose.composeBom))
        implementations(Libs.Compose.composeDep)
    }
}

private fun DependencyHandler.implementationsDagger() {
    implementation(Libs.Dagger.daggerAndroid)
    kapt (Libs.Dagger.daggerCompiler)
}

private fun DependencyHandler.implementationsGlide(isNeed: Boolean) {
    if (isNeed) {
        implementation(Libs.Glide.glide)
        kapt (Libs.Glide.glideCompiler)
    }
}
