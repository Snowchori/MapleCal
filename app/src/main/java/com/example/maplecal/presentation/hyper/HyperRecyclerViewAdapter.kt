package com.example.maplecal.presentation.hyper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.maplecal.ItemSelectedListener
import com.example.maplecal.R
import com.example.maplecal.domain.model.Hyper
import com.example.maplecal.databinding.ItemRecyclerHyperBinding

class HyperRecyclerViewAdapter(
    private var dataSet: List<Hyper>,
    val hyperCountChangeListener: (Int, String) -> Unit,
    val context: Context
    ) :
    RecyclerView.Adapter<HyperRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemRecyclerHyperBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    hyperCountChangeListener(adapterPosition, position.toString())
                }

                override fun onNothingSelected(p0: AdapterView<*>?) = Unit

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ItemRecyclerHyperBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.status.text = dataSet[position].hyperName
        holder.binding.spinner.adapter = ArrayAdapter.createFromResource(
            context,
            R.array.numberList,
            android.R.layout.simple_spinner_item
        )
        holder.binding.spinner.setSelection(dataSet[position].hyperCount.toInt())
    }

    override fun getItemCount(): Int = dataSet.size

    fun setData(newData:List<Hyper>) {
        dataSet = newData
        notifyDataSetChanged()
    }
}
