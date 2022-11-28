import ru.apshheko.buildsrc.deps
import ru.apshheko.buildsrc.Libs.coreDep
import ru.apshheko.buildsrc.Libs.coreTestDep
import ru.apshheko.buildsrc.Libs.coreUITestDep
import ru.apshheko.buildsrc.dependencies
import ru.apshheko.buildsrc.Apps
import ru.apshheko.buildsrc.Libs.Retrofit.retrofitDep
import ru.apshheko.buildsrc.Modules.baseApp

plugins {
    id("com.android.library")
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
        coreDep,
        retrofitDep
    ),
    testImplementations = deps(
        coreTestDep
    ),
    androidTestImplementations = deps(
        coreUITestDep
    ),
    modules = deps(
        baseApp
    )
)