package com.example.maplecal.presentation.park

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maplecal.databinding.ParkDialogBinding
import com.example.maplecal.util.resize

class ParkDialog : DialogFragment() {
    private lateinit var binding: ParkDialogBinding
    private lateinit var adapter: ParkResultRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ParkDialogBinding.inflate(layoutInflater)
        arguments?.let {
            it.getParcelableArrayList<ParkResult>("park").toString()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onStart() {
        super.onStart()
        resize(0.9f, 0.9f)
    }

    private fun initView() {
        initParkRecyclerView()
        initButton()
    }

    private fun initParkRecyclerView() {
        adapter = ParkResultRecyclerViewAdapter()
        arguments?.let {
            val data = mutableListOf<ParkResult>()
            val saveData = it.getParcelableArrayList<ParkResult>("park")
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