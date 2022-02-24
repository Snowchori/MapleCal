package com.example.maplecal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.maplecal.data.SymbolData
import com.example.maplecal.databinding.ItemRecyclerSymbolBinding

class SymbolRecyclerViewAdapter : RecyclerView.Adapter<SymbolRecyclerViewAdapter.MyViewHolder>() {
    var datalist = mutableListOf<SymbolData>()

    inner class MyViewHolder(val binding: ItemRecyclerSymbolBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.levelEdit.addTextChangedListener {
                datalist[adapterPosition].symbolLevel = it.toString()
            }
            binding.countEdit.addTextChangedListener {
                datalist[adapterPosition].symbolCount = it.toString()
            }
            binding.extraEdit.addTextChangedListener {
                datalist[adapterPosition].symbolMini = it.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ItemRecyclerSymbolBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.symbolImage.setImageResource(datalist[position].symbolImg)
        holder.binding.symbolName.text = datalist[position].symbolName
        holder.binding.extraBool.text = datalist[position].symbolExtra
        holder.binding.levelEdit.setText(datalist[position].symbolLevel)
        holder.binding.countEdit.setText(datalist[position].symbolCount)
        holder.binding.extraEdit.setText(datalist[position].symbolMini)
    }

    override fun getItemCount(): Int = datalist.size

    fun addItem(symbolData: SymbolData, ind: Int) {
        for (i in 0 until this.datalist.size) {
            if (this.datalist[i].symbolIndex == ind) return
        }
        this.datalist.add(symbolData)
        this.datalist.sortBy { it.symbolIndex }
        notifyDataSetChanged()
    }

    fun removeItem(ind: Int) {
        for (i in 0 until this.datalist.size) {
            if (this.datalist[i].symbolIndex == ind) {
                this.datalist.removeAt(i)
                break
            }
        }
        notifyDataSetChanged()
    }
}