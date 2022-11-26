import ru.apshheko.buildsrc.androidTestImplementations
import ru.apshheko.buildsrc.config.Apps
import ru.apshheko.buildsrc.implementations
import ru.apshheko.buildsrc.testImplementations
import ru.apshheko.buildsrc.config.Libs.coreDep
import ru.apshheko.buildsrc.config.Libs.coreTestDep
import ru.apshheko.buildsrc.config.Libs.coreUITestDep
import ru.apshheko.buildsrc.config.Modules.commonExample
import ru.apshheko.buildsrc.config.Modules.featureExample
import ru.apshheko.buildsrc.modulesDep

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

repositories {
    google()
    mavenCentral()
}

android {

    compileSdk = Apps.compileSdk

    defaultConfig {
        applicationId = Apps.applicationId
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = Apps.testInstrumentationRunner
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
    packagingOptions {
        resources {
            excludes += Apps.packagingOptionsExcludes
        }
    }
}

dependencies {
    implementations(coreDep)
    testImplementations(coreTestDep)
    androidTestImplementations(coreUITestDep)
    modulesDep(
        commonExample,
        featureExample
    )
}