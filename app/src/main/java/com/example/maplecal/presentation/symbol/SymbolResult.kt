package com.example.maplecal.presentation.symbol

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SymbolResult(
    val symbolIndex: Int,
    val symbolName: String,
    val symbolMeso: String,
    val symbolGain: String
) : Parcelable