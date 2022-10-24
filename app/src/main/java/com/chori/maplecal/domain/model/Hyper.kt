package com.chori.maplecal.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hyper(
    val hyperIndex: Int,
    val hyperName: String,
    var hyperCount: String
) : Parcelable