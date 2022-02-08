package com.example.maplecal.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maplecal.adapter.ParkResultRecyclerViewAdapter
import com.example.maplecal.data.ParkData
import com.example.maplecal.databinding.ParkDialogBinding

class ParkDialog : DialogFragment() {
    private lateinit var binding : ParkDialogBinding
    private lateinit var adapter : ParkResultRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ParkDialogBinding.inflate(layoutInflater)
        arguments?.let {
            it.getParcelableArrayList<ParkData>("park").toString()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        initParkRecyclerView()
        initButton()
    }

    private fun initParkRecyclerView() {
        adapter = ParkResultRecyclerViewAdapter()
        arguments?.let {
            val data = mutableListOf<ParkData>()
            val saveData = it.getParcelableArrayList<ParkData>("park")
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

    private fun initButton() {
        binding.previousButton.setOnClickListener {
            dismiss()
        }
    }
}