package com.example.maplecal

import com.google.gson.annotations.SerializedName

data class ExpResponse(
    @SerializedName("error")
    val error: String,

    @SerializedName("result")
    val result: String
)