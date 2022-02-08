package com.example.maplecal.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maplecal.data.SymbolData
import com.example.maplecal.databinding.ItemRecyclerSymbolResultBinding
import com.example.maplecal.model.*
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class SymbolResultRecyclerViewAdapter : RecyclerView.Adapter<SymbolResultRecyclerViewAdapter.MyViewHolder>(){
    var datalist = mutableListOf<SymbolData>()

    class MyViewHolder(val binding: ItemRecyclerSymbolResultBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRecyclerSymbolResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.symbolImage.setImageResource(datalist[position].symbolImg)
        holder.binding.symbolName.text = datalist[position].symbolName
        holder.binding.requestMeso.text = getMeso(datalist[position].symbolIndex, datalist[position].symbolLevel.toInt())
        holder.binding.symbolGain.text = getTime(datalist[position].symbolIndex, datalist[position].symbolLevel.toInt(),
            datalist[position].symbolCount.toInt(), datalist[position].symbolMini.toInt())
    }

    override fun getItemCount(): Int = datalist.size

    private fun getMeso(ind : Int, level : Int) : String {
        val dec = DecimalFormat("#,###")
        val meso = when (ind) {
            0 -> getArcaneMesoLongway(level, 20)
            1 -> getArcaneMesoChuchu(level, 20)
            2 -> getArcaneMesoMoras(level, 20)
            3, 4, 5 -> getArcaneMesoEtc(level, 20)
            6 -> getAuthenticMesoCernium(level, 11)
            7 -> getAuthenticMesoArx(level, 11)
            else -> -1
        }

        return dec.format(meso)
    }

    @SuppressLint("SimpleDateFormat")
    private fun getTime(ind : Int, level : Int, count : Int, mini : Int) : String {
        var remain : Int = when(ind) {
            0, 1, 2, 3, 4 ,5 -> getArcaneGrowth(level - 1, 19)
            6, 7 -> getAuthenticGrowth(level - 1, 10)
            else -> 0
        }

        remain -= count

        val day : Int = when(ind) {
            0 -> 16 + 6*mini
            1 -> 8 + 15*mini
            2 -> 9 + mini/10
            3 -> 8 + mini/3000
            4, 5 -> 8 + 6*mini
            6 -> 5 + 5*mini
            7 -> 5
            else -> -1
        }

        val t : Int = (remain + 1)/day

        val cal = Calendar.getInstance()
        cal.time = Date()
        val df : DateFormat = SimpleDateFormat("yyyy-MM-dd")

        cal.add(Calendar.DATE, t)

        return df.format(cal.time)
    }
}