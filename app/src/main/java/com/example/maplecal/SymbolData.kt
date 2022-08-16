package com.example.maplecal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SymbolData(
    val symbolIndex: Int,
    val symbolImg: Int,
    val symbolName: String,
    val symbolExtra: String,
    var symbolLevel: String,
    var symbolCount: String,
    var symbolMini: String
) : Parcelable