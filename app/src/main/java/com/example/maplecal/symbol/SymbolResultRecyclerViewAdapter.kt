package com.example.maplecal.symbol

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maplecal.domain.model.Symbol
import com.example.maplecal.databinding.ItemRecyclerSymbolResultBinding
import com.example.maplecal.model.*
import com.example.maplecal.symbols
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class SymbolResultRecyclerViewAdapter :
    RecyclerView.Adapter<SymbolResultRecyclerViewAdapter.MyViewHolder>() {
    var datalist = mutableListOf<Symbol>()

    class MyViewHolder(val binding: ItemRecyclerSymbolResultBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRecyclerSymbolResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.symbolImage.setImageResource(symbols[datalist[position].symbolIndex])
        holder.binding.symbolName.text = datalist[position].symbolName
        holder.binding.requestMeso.text = ""
                //getMeso(datalist[position].symbolIndex, datalist[position].symbolLevel.toInt())
        holder.binding.symbolGain.text = ""
                /*getTime(
            datalist[position].symbolIndex, datalist[position].symbolLevel.toInt(),
            datalist[position].symbolCount.toInt(), datalist[position].symbolMini.toInt()
        )
        */
    }

    override fun getItemCount(): Int = datalist.size
}