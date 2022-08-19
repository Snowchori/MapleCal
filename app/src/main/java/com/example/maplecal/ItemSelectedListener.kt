package com.example.maplecal

import com.example.maplecal.domain.model.Hyper

interface ItemSelectedListener {
    fun onHyperSelected(data: MutableList<Hyper>)
}