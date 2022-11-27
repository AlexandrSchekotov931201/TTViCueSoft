package ru.apshheko.buildsrc

object Libs {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterialVersion}"

    const val junit = "junit:junit:${Versions.junitVersion}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunitVersion}"
    const val coreEspresso = "androidx.test.espresso:espresso-core:${Versions.coreEspressoVersion}"

    val coreDep = listOf(
        coreKtx,
        appCompat,
        androidMaterial
    )

    val coreTestDep = listOf(
        junit,
        extJunit,
        coreEspresso,
    )

    val coreUITestDep = listOf(
        coreEspresso
    )

    object Compose {
        const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
        const val composeMaterial = "androidx.compose.material:material"
        const val composeUI = "androidx.compose.ui:ui"
        const val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val composeUITooling = "androidx.compose.ui:ui-tooling"
        const val composeActivity = "androidx.activity:activity-compose"

        val composeDep = listOf(
            composeMaterial,
            composeUI,
            composeUIToolingPreview,
            composeUITooling,
            composeActivity
        )
    }

    object ExoPlayer {
        const val exoPlayer = "com.google.android.exoplayer:exoplayer:${Versions.exoPlayerVersion}"
        const val exoPlayerUI = "com.google.android.exoplayer:exoplayer-ui:${Versions.exoPlayerVersion}"

        val exoPlayerDep = listOf(
            exoPlayer,
            exoPlayerUI
        )
    }

    object Dagger {
        const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

        val retrofitDep = listOf(
            retrofit,
            retrofitConverterGson
        )
    }

    object RxJava {
        const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxjavaVersion}"
        const val rxJavaAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxjavaAndroidVersion}"

        val rxJavaDep = listOf(
            rxJava,
            rxJavaAndroid
        )
    }

    object Coroutines {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0"

        val coroutinesDep = listOf(
            coroutinesCore,
            coroutinesAndroid
        )
    }
}