package com.example.maplecal

import com.example.maplecal.data.HyperData

interface ItemSelectedListener {
    fun onHyperSelected(data: MutableList<HyperData>)
}