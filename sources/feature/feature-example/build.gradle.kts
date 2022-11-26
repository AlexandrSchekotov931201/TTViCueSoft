import ru.apshheko.buildsrc.*
import ru.apshheko.buildsrc.config.Apps
import ru.apshheko.buildsrc.config.Libs.coreDep
import ru.apshheko.buildsrc.config.Libs.coreTestDep
import ru.apshheko.buildsrc.config.Libs.coreUITestDep

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

repositories {
    google()
    mavenCentral()
}

android {
    compileSdk = Apps.compileSdk

    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk

        testInstrumentationRunner = Apps.testInstrumentationRunner
        consumerProguardFiles(Apps.consumerRules)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(Apps.defaultProguardFile), Apps.proguardRules
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Apps.jvmTarget
    }
}

dependencies(
    implementations = deps(
        coreDep
    ),
    testImplementations = deps(
        coreTestDep
    ),
    androidTestImplementations = deps(
        coreUITestDep
    )
)