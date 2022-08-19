package com.example.maplecal.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Park(
    val parkIndex: Int,
    val parkName: String,
    var parkCount: String,
    var parkPoint: String
) : Parcelable