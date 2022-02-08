package com.example.maplecal.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ParkData(
    val parkIndex : Int,
    val parkImg : Int,
    val parkName : String,
    var parkCount : String,
    var parkPoint : String
) : Parcelable