package com.example.maplecal.symbol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maplecal.SymbolData
import com.example.maplecal.databinding.SymbolDialogBinding
import com.example.maplecal.util.resize

class SymbolDialog : DialogFragment() {
    private lateinit var binding: SymbolDialogBinding
    private lateinit var adapter: SymbolResultRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SymbolDialogBinding.inflate(layoutInflater)
        arguments?.let {
            it.getParcelableArrayList<SymbolData>("symbol").toString()
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        resize(0.9f, 0.9f)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        initSymbolRecyclerView()
        initButton()
    }

    private fun initSymbolRecyclerView() {
        adapter = SymbolResultRecyclerViewAdapter()
        arguments?.let {
            val data = mutableListOf<SymbolData>()
            val saveData = it.getParcelableArrayList<SymbolData>("symbol")
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