package com.chori.maplecal.presentation.park

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ParkResult(
    val parkIndex: Int,
    val parkName: String,
    val parkPoint: String,
    val parkTime: String
) : Parcelable
