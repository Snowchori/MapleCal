package com.example.maplecal

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.maplecal.databinding.ActivityMainBinding
import com.example.maplecal.databinding.ItemRecyclerSymbolBinding
import com.example.maplecal.model.symbols

class SymbolRecyclerViewAdapter : RecyclerView.Adapter<SymbolRecyclerViewAdapter.MyViewHolder>() {
    var datalist = mutableListOf<SymbolData>()

    inner class MyViewHolder(private val binding: ItemRecyclerSymbolBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(symbolData: SymbolData, ind : Int){
            binding.symbolImage.setImageResource(symbolData.symbolImg)
            binding.symbolName.text = symbolData.symbolName
            binding.extraBool.text = symbolData.symbolExtra
            binding.levelEdit.setText(symbolData.symbolLevel.toString())
            binding.countEdit.setText(symbolData.symbolCount.toString())
            binding.extraEdit.setText(symbolData.symbolMini.toString())

            binding.levelEdit.addTextChangedListener { datalist[ind].symbolLevel = it.toString().toInt() }
            binding.countEdit.addTextChangedListener { datalist[ind].symbolCount = it.toString().toInt() }
            binding.extraEdit.addTextChangedListener { datalist[ind].symbolMini = it.toString().toInt() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRecyclerSymbolBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position], position)
    }

    override fun getItemCount(): Int = datalist.size

    fun addItem(ind : Int) {
        this.datalist.add(symbols[ind])
        this.datalist.sortBy { it.symbolIndex }
        notifyDataSetChanged()
    }

    fun removeItem(ind : Int) {
        for (i in 0 until this.datalist.size) {
            if (this.datalist[i].symbolIndex == ind) {
                this.datalist.removeAt(i)
                break
            }
        }
        notifyDataSetChanged()
    }
}