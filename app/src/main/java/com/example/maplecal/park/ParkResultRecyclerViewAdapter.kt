package com.example.maplecal.park

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maplecal.domain.model.Park
import com.example.maplecal.databinding.ItemRecyclerParkResultBinding
import com.example.maplecal.parks
import com.example.maplecal.util.getPoint
import com.example.maplecal.util.getTime
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class ParkResultRecyclerViewAdapter :
    RecyclerView.Adapter<ParkResultRecyclerViewAdapter.MyViewHolder>() {
    var datalist = mutableListOf<Park>()

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
        holder.binding.requestPoint.text =
            getPoint(datalist[position].parkCount.toInt(), datalist[position].parkPoint.toInt())
        holder.binding.parkGain.text = getTime(
            datalist[position].parkIndex,
            datalist[position].parkCount.toInt(), datalist[position].parkPoint.toInt()
        )
    }

    override fun getItemCount(): Int = datalist.size


    // 계산하는 유틸로

}