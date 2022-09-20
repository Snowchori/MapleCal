package com.example.maplecal.presentation.symbol

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.maplecal.R
import com.example.maplecal.databinding.ItemRecyclerSymbolBinding
import com.example.maplecal.domain.model.Symbol

class SymbolRecyclerViewAdapter(
    val symbolLevelChangeListener: (Int, String) -> Unit,
    val symbolCountChangeListener: (Int, String) -> Unit,
    val symbolMiniChangeListener: (Int, String) -> Unit
) : RecyclerView.Adapter<SymbolRecyclerViewAdapter.MyViewHolder>() {

    private var dataSet : List<Symbol> = emptyList()

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

    inner class MyViewHolder(val binding: ItemRecyclerSymbolBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.levelEdit.addTextChangedListener {
                symbolLevelChangeListener(dataSet[adapterPosition].symbolIndex, it.toString())
            }
            binding.countEdit.addTextChangedListener {
                symbolCountChangeListener(dataSet[adapterPosition].symbolIndex, it.toString())
            }
            binding.extraEdit.addTextChangedListener {
                symbolMiniChangeListener(dataSet[adapterPosition].symbolIndex, it.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ItemRecyclerSymbolBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listposition = dataSet[position]
        holder.binding.symbolImage.setImageResource(symbols[listposition.symbolIndex])
        holder.binding.symbolName.text = listposition.symbolName
        holder.binding.extraBool.text = listposition.symbolExtra
        holder.binding.levelEdit.setText(listposition.symbolLevel)
        holder.binding.countEdit.setText(listposition.symbolCount)
        holder.binding.extraEdit.setText(listposition.symbolMini)
    }

    override fun getItemCount(): Int = dataSet.size

    fun setData(newData:List<Symbol>) {
        dataSet = newData
        notifyDataSetChanged()
    }
}