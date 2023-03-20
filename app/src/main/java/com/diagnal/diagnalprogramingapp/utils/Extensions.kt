package com.diagnal.diagnalprogramingapp.utils

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("DiscouragedApi")
fun String.toDrawable(c: Context): Int {
    return c.resources.getIdentifier(this, "drawable", c.packageName)
}
