package com.example.maplecal.presentation.park

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maplecal.R
import com.example.maplecal.domain.model.Park
import com.example.maplecal.databinding.ItemRecyclerParkResultBinding
import com.example.maplecal.util.getPoint
import com.example.maplecal.util.getTime

class ParkResultRecyclerViewAdapter :
    RecyclerView.Adapter<ParkResultRecyclerViewAdapter.MyViewHolder>() {
    var datalist = mutableListOf<ParkResult>()

    val parks = listOf(
        R.drawable.sunday,
        R.drawable.monday,
        R.drawable.tuesday,
        R.drawable.wednesday,
        R.drawable.thursday,
        R.drawable.friday,
        R.drawable.saturday
    )

    class MyViewHolder(val binding: ItemRecyclerParkResultBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRecyclerParkResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.parkImage.setImageResource(parks[datalist[position].parkIndex])
        holder.binding.parkName.text = datalist[position].parkName
        holder.binding.requestPoint.text = datalist[position].parkPoint
        holder.binding.parkGain.text = datalist[position].parkTime
    }

    override fun getItemCount(): Int = datalist.size
}