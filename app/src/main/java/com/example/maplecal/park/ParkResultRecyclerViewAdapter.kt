package com.example.maplecal.park

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maplecal.ParkData
import com.example.maplecal.databinding.ItemRecyclerParkResultBinding
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class ParkResultRecyclerViewAdapter :
    RecyclerView.Adapter<ParkResultRecyclerViewAdapter.MyViewHolder>() {
    var datalist = mutableListOf<ParkData>()

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
        holder.binding.parkImage.setImageResource(datalist[position].parkImg)
        holder.binding.parkName.text = datalist[position].parkName
        holder.binding.requestPoint.text =
            getPoint(datalist[position].parkCount.toInt(), datalist[position].parkPoint.toInt())
        holder.binding.parkGain.text = getTime(
            datalist[position].parkIndex,
            datalist[position].parkCount.toInt(), datalist[position].parkPoint.toInt()
        )
    }

    override fun getItemCount(): Int = datalist.size

    private fun getPoint(cnt: Int, point: Int): String {
        val dec = DecimalFormat("#,###")
        val remain = 77 - cnt
        val q: Int = remain / (2 + point)
        val r = remain % (2 + point) - 2
        return if (r > 0) {
            dec.format(300 * (q * point + r))
        } else {
            dec.format(300 * q * point)
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getTime(ind: Int, cnt: Int, point: Int): String {
        val remain = 78 - cnt
        val week = remain / (2 + point)

        val cal = Calendar.getInstance()
        var temp = ind + 1 - cal.get(Calendar.DAY_OF_WEEK)
        if (temp < 0) temp += 7
        cal.time = Date()

        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")

        cal.add(Calendar.DATE, temp + week * 7)

        return df.format(cal.time)
    }
}