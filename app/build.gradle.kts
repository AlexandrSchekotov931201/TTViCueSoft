import ru.apshheko.buildsrc.Libs.coreDep
import ru.apshheko.buildsrc.Libs.coreTestDep
import ru.apshheko.buildsrc.Libs.coreUITestDep
import ru.apshheko.buildsrc.Apps
import ru.apshheko.buildsrc.Modules.baseApp
import ru.apshheko.buildsrc.Modules.networkApi
import ru.apshheko.buildsrc.Modules.networkImpl
import ru.apshheko.buildsrc.Modules.videoPlayerScreen
import ru.apshheko.buildsrc.dependencies
import ru.apshheko.buildsrc.deps

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
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

dependencies(
    implementations = deps(
        coreDep
    ),
    testImplementations = deps(
        coreTestDep
    ),
    androidTestImplementations = deps(
        coreUITestDep
    ),
    modules = deps(
        baseApp,
        videoPlayerScreen,
        networkImpl,
        networkApi
    )
)