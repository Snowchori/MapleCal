package com.example.maplecal.park

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maplecal.R
import com.example.maplecal.ParkData
import com.example.maplecal.databinding.FragmentParkBinding

class ParkFragment : Fragment(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: FragmentParkBinding
    private lateinit var adapter: ParkRecyclerViewAdapter
    private lateinit var parks: Array<ParkData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentParkBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {
        parks = arrayOf(
            ParkData(0, R.drawable.sunday, "일요일 훈장", "0", "0"),
            ParkData(1, R.drawable.monday, "월요일 훈장", "0", "0"),
            ParkData(2, R.drawable.tuesday, "화요일 훈장", "0", "0"),
            ParkData(3, R.drawable.wednesday, "수요일 훈장", "0", "0"),
            ParkData(4, R.drawable.thursday, "목요일 훈장", "0", "0"),
            ParkData(5, R.drawable.friday, "금요일 훈장", "0", "0"),
            ParkData(6, R.drawable.saturday, "토요일 훈장", "0", "0")
        )
        initParkRecyclerView(savedInstanceState)
        initParkCheckBox()
        initButton()
    }

    private fun initParkRecyclerView(savedInstanceState: Bundle?) {
        adapter = ParkRecyclerViewAdapter()
        if (savedInstanceState != null) {
            val data = mutableListOf<ParkData>()
            val saveData = savedInstanceState.getParcelableArrayList<ParkData>("parkData")
            if (saveData != null) {
                for (i in 0 until saveData.size) {
                    data.add(saveData[i])
                }
            }
            adapter.datalist = data
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun initParkCheckBox() {
        binding.parkSun.setOnCheckedChangeListener(this)
        binding.parkMon.setOnCheckedChangeListener(this)
        binding.parkTue.setOnCheckedChangeListener(this)
        binding.parkWed.setOnCheckedChangeListener(this)
        binding.parkThu.setOnCheckedChangeListener(this)
        binding.parkFri.setOnCheckedChangeListener(this)
        binding.parkSat.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(checkbox: CompoundButton, isChecked: Boolean) {
        val park = when (checkbox.id) {
            R.id.park_sun -> 0
            R.id.park_mon -> 1
            R.id.park_tue -> 2
            R.id.park_wed -> 3
            R.id.park_thu -> 4
            R.id.park_fri -> 5
            R.id.park_sat -> 6
            else -> return
        }

        when (isChecked) {
            true -> adapter.addItem(parks[park], park)
            false -> adapter.removeItem(park)
        }
    }

    fun initButton() {
        binding.calButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelableArrayList("park", ArrayList(adapter.datalist))
            val dialog = ParkDialog()
            dialog.isCancelable = false
            dialog.arguments = bundle
            dialog.show(childFragmentManager, "Park Dialog")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("parkData", ArrayList(adapter.datalist))
    }

    companion object {
        const val TAG = "ParkFragment"

        @JvmStatic
        fun newInstance() = ParkFragment()
    }
}