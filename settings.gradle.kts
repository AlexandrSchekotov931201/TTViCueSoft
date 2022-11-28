pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
rootProject.name = "TTViCueSoft"

//инициализация модулей из корневой директории
initModules(rootDir, 1)
//инициализация всех модулей из папки sources
initModules(File(rootDir, "sources"), 3)

/**
 * Функция для автоматической регистрации проектных модулей из папки sourceDir в сборке гредл
 * @param sourceDir папка, которая содержит пакеты с гредл модулями
 * @param depth глубина поиска гредл модулей в папке sourceDir
 */
fun initModules(sourceDir: File, depth: Int) {
    sourceDir
        .walk()
        .maxDepth(depth)
        .filter {
            it.isDirectory
                    && it.absolutePath != sourceDir.path
                    && isGradleProject(it)
                    && !it.name.matches("buildSrc".toRegex())
        }
        .forEach {
            val moduleName = ":${it.name}"
            include(moduleName)
            project(moduleName).projectDir = file(it.path)
        }
}

fun isGradleProject(file: File): Boolean {
    return file.isDirectory && (file("${file.absolutePath}/build.gradle.kts").exists() || file("${file.absolutePath}/build.gradle").exists())
}
