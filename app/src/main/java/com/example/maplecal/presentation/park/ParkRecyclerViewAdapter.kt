package com.example.maplecal.presentation.park

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.maplecal.R
import com.example.maplecal.domain.model.Park
import com.example.maplecal.databinding.ItemRecyclerParkBinding


class ParkRecyclerViewAdapter(
    private var dataSet: List<Park>,
    val parkCountChangeListener: (Int, String) -> Unit,
    val parkPointChangeListener: (Int, String) -> Unit
) : RecyclerView.Adapter<ParkRecyclerViewAdapter.MyViewHolder>() {

    val parks = listOf(
        R.drawable.sunday,
        R.drawable.monday,
        R.drawable.tuesday,
        R.drawable.wednesday,
        R.drawable.thursday,
        R.drawable.friday,
        R.drawable.saturday
    )

    inner class MyViewHolder(val binding: ItemRecyclerParkBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.countEdit.addTextChangedListener {
                parkCountChangeListener(dataSet[adapterPosition].parkIndex, it.toString())
            }
            binding.pointEdit.addTextChangedListener {
                parkPointChangeListener(dataSet[adapterPosition].parkIndex, it.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ItemRecyclerParkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.parkImage.setImageResource(parks[dataSet[position].parkIndex])
        holder.binding.parkName.text = dataSet[position].parkName
        holder.binding.countEdit.setText(dataSet[position].parkCount)
        holder.binding.pointEdit.setText(dataSet[position].parkPoint)
    }

    override fun getItemCount(): Int = dataSet.size

    fun setData(newData:List<Park>) {
        dataSet = newData
        notifyDataSetChanged()
    }
}