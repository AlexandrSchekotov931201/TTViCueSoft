package ru.apshheko.buildsrc

import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

fun Project.dependencies(
    implementations: List<List<String>>? = null,
    testImplementations: List<List<String>>? = null,
    androidTestImplementations: List<List<String>>? = null,
    modules: List<String>? = null
) {
    dependencies {
        implementations?.forEach { implementations(it) }
        testImplementations?.forEach { testImplementations(it) }
        androidTestImplementations?.forEach { androidTestImplementations(it) }
        modules?.forEach { modulesDep(it) }
    }
}

fun DependencyHandler.implementations(vararg dependency: List<Any>) {
    dependency.forEach { deps ->
        deps.forEach {
            add("implementation", it)
        }
    }
}

fun DependencyHandler.testImplementations(vararg dependency: List<Any>) {
    dependency.forEach { deps ->
        deps.forEach {
            add("testImplementation", it)
        }
    }
}

fun DependencyHandler.androidTestImplementations(vararg dependency: List<Any>) {
    dependency.forEach { deps ->
        deps.forEach {
            add("androidTestImplementation", it)
        }
    }
}

fun DependencyHandler.modulesDep(vararg modules: Any) {
    modules.forEach { add("implementation", project(":$it")) }
}

fun deps(vararg impl: List<String>): List<List<String>> = impl.asList()
fun deps(vararg impl: String): List<String> = impl.toList()
