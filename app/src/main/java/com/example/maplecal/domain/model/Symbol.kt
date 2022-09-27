package com.example.maplecal.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Symbol(
    val symbolIndex: Int,
    val symbolName: String,
    val symbolExtra: String,
    var symbolLevel: String,
    var symbolCount: String,
    var symbolMini: String,
    var symbolCheked: Boolean
) : Parcelable