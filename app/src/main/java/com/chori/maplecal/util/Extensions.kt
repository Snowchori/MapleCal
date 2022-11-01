package com.chori.maplecal.util

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.view.WindowManager
import androidx.fragment.app.DialogFragment

fun DialogFragment.resize(width: Float, height: Float) {
    val windowManager =
        (this.context?.getSystemService(Context.WINDOW_SERVICE) as? WindowManager) ?: return

    if (Build.VERSION.SDK_INT < 30) {
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val window = this.dialog?.window
        val x = (size.x * width).toInt()
        val y = (size.y * height).toInt()
        window?.setLayout(x, y)
    } else {
        val rect = windowManager.currentWindowMetrics.bounds
        val window = this.dialog?.window
        val x = (rect.width() * width).toInt()
        val y = (rect.height() * height).toInt()
        window?.setLayout(x, y)
    }
}