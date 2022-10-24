package com.chori.maplecal.presentation.symbol

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chori.maplecal.R
import com.chori.maplecal.databinding.ItemRecyclerSymbolResultBinding

class SymbolResultRecyclerViewAdapter :
    RecyclerView.Adapter<SymbolResultRecyclerViewAdapter.MyViewHolder>() {
    var datalist = mutableListOf<SymbolResult>()

    private val symbols = listOf(
        R.drawable.longways,
        R.drawable.chuchu,
        R.drawable.lehlne,
        R.drawable.arcana,
        R.drawable.moras,
        R.drawable.espa,
        R.drawable.cernium,
        R.drawable.arx
    )

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
        holder.binding.requestMeso.text = datalist[position].symbolMeso
        holder.binding.symbolGain.text = datalist[position].symbolGain
    }

    override fun getItemCount(): Int = datalist.size
}