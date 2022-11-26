package ru.apshheko.buildsrc.config

object Libs {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterialVersion}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"

    const val junit = "junit:junit:${Versions.junitVersion}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunitVersion}"
    const val coreEspresso = "androidx.test.espresso:espresso-core:${Versions.coreEspressoVersion}"

    val coreDep = listOf(
        coreKtx,
        appCompat,
        androidMaterial,
        constraintlayout,
    )

    val coreTestDep = listOf(
        junit,
        extJunit,
        coreEspresso,
    )

    val coreUITestDep = listOf(
        coreEspresso
    )
}