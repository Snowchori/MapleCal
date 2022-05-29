package com.example.maplecal.data

import com.google.gson.annotations.SerializedName

data class ExpResponse(
    @SerializedName("error")
    val error: String,

    @SerializedName("result")
    val result: String
)