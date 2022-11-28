package ru.apshheko.designsystem.ext

import android.content.Context
import android.util.TypedValue

fun Context.dpToPx(valueInDp: Int): Int {
    val metrics = resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp.toFloat(), metrics).toInt()
}