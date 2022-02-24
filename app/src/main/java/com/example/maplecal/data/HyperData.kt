package com.example.maplecal.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HyperData(
    val hyperIndex: Int,
    val hyperName: String,
    var hyperCount: Int
) : Parcelable