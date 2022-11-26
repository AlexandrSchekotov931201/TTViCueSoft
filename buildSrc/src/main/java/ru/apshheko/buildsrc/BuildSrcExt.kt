package ru.apshheko.buildsrc

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.implementations(dependencyNotation: List<Any>) {
    dependencyNotation.forEach { add("implementation", it) }
}

fun DependencyHandler.testImplementations(dependencyNotation: List<Any>) {
    dependencyNotation.forEach { add("testImplementation", it) }
}

fun DependencyHandler.androidTestImplementations(dependencyNotation: List<Any>) {
    dependencyNotation.forEach { add("androidTestImplementation", it) }
}

fun DependencyHandler.modulesDep(vararg modules: String) {
    modules.forEach { add("implementation", project(":$it")) }
}