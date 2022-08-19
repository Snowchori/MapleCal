package com.example.maplecal.park

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.maplecal.domain.model.Park
import com.example.maplecal.databinding.ItemRecyclerParkBinding
import com.example.maplecal.parks


class ParkRecyclerViewAdapter : RecyclerView.Adapter<ParkRecyclerViewAdapter.MyViewHolder>() {
    var datalist = mutableListOf<Park>()

    inner class MyViewHolder(val binding: ItemRecyclerParkBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.countEdit.addTextChangedListener {
                datalist[adapterPosition].parkCount = it.toString()
            }
            binding.pointEdit.addTextChangedListener {
                datalist[adapterPosition].parkPoint = it.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ItemRecyclerParkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.parkImage.setImageResource(parks[datalist[position].parkIndex])
        holder.binding.parkName.text = datalist[position].parkName
        holder.binding.countEdit.setText(datalist[position].parkCount)
        holder.binding.pointEdit.setText(datalist[position].parkPoint)
    }

    override fun getItemCount(): Int = datalist.size

    fun addItem(park: Park, ind: Int) {
        for (i in 0 until this.datalist.size) {
            if (this.datalist[i].parkIndex == ind) return
        }
        this.datalist.add(park)
        this.datalist.sortBy { it.parkIndex }
        notifyDataSetChanged()
    }

    fun removeItem(ind: Int) {
        for (i in 0 until this.datalist.size) {
            if (this.datalist[i].parkIndex == ind) {
                this.datalist.removeAt(i)
                break
            }
        }
        notifyDataSetChanged()
    }
}