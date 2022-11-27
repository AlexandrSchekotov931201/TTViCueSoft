package ru.apshheko.buildsrc

import org.gradle.api.Action
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import org.gradle.kotlin.dsl.project

fun DependencyHandler.compileOnly(dependency: Any) {
    add("compileOnly", dependency)
}

fun DependencyHandler.implementation(dependency: Any) {
    add("implementation", dependency)
}

fun DependencyHandler.api(dependency: Any) {
    add("api", dependency)
}

fun DependencyHandler.implementation(
        dependencyNotation: String,
        dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
        this, "implementation", dependencyNotation, dependencyConfiguration
)

fun DependencyHandler.testImplementation(dependency: Any) {
    add("testImplementation", dependency)
}

fun DependencyHandler.testImplementation(
        dependencyNotation: String,
        dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
        this, "testImplementation", dependencyNotation, dependencyConfiguration
)

fun DependencyHandler.androidTestImplementation(dependency: Any) {
    add("androidTestImplementation", dependency)
}

fun DependencyHandler.androidTestImplementation(
        dependencyNotation: String,
        dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
        this, "androidTestImplementation", dependencyNotation, dependencyConfiguration
)

fun DependencyHandler.kapt(dependencyNotation: Any) {
    add("kapt", dependencyNotation)
}

fun DependencyHandler.debugImplementation(
        dependencyNotation: String,
        dependencyConfiguration: Action<ExternalModuleDependency>): ExternalModuleDependency {
    return addDependencyTo(
            this, "debugImplementation", dependencyNotation, dependencyConfiguration
    )
}

fun DependencyHandler.releaseImplementation(dependency: Any) {
    add("releaseImplementation", dependency)
}

fun DependencyHandler.lintChecks(dependency: Any) {
    add("lintChecks", dependency)
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