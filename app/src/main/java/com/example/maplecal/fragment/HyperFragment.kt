package com.example.maplecal.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maplecal.R
import com.example.maplecal.adapter.HyperRecyclerViewAdapter
import com.example.maplecal.data.HyperData
import com.example.maplecal.databinding.FragmentHyperBinding
import com.example.maplecal.databinding.ItemRecyclerParkResultBinding
import com.example.maplecal.model.getGainPoint
import com.example.maplecal.model.getHyper
import java.lang.NumberFormatException

class HyperFragment : Fragment() {
    private lateinit var binding: FragmentHyperBinding
    private lateinit var adapter: HyperRecyclerViewAdapter
    private lateinit var hypers: Array<HyperData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHyperBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {
        initHyperRecyclerView(savedInstanceState)
        initButton()
        binding.levelEdit.addTextChangedListener {
            try {
                val level = Integer.parseInt(it.toString())
                if (level >= 140) binding.pointText.setText(getGainPoint(level).toString())
                else binding.pointText.setText("0")
            } catch (e: NumberFormatException) {
            }
        }
        if (savedInstanceState != null) {
            val level = savedInstanceState.getString("level")
            if (level != null) binding.levelEdit.setText(level)
        }
    }

    private fun initHyperRecyclerView(savedInstanceState: Bundle?) {
        adapter = HyperRecyclerViewAdapter(requireContext())
        hypers = getHyper()
        val data = mutableListOf<HyperData>()
        if (savedInstanceState != null) {
            val saveData = savedInstanceState.getParcelableArrayList<HyperData>("hyperData")
            if (saveData != null) {
                for (i in 0 until saveData.size) {
                    data.add(saveData[i])
                }
            }
        } else {
            for (i in 0 until hypers.size) {
                data.add(hypers[i])
            }
        }
        adapter.datalist = data
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun initButton() {
        binding.initButton.setOnClickListener {
            val data = mutableListOf<HyperData>()
            for (i in 0 until hypers.size) {
                data.add(hypers[i])
            }
            adapter.datalist = data
            binding.recyclerView.adapter?.notifyDataSetChanged()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("hyperData", ArrayList(adapter.datalist))
        outState.putString("level", binding.levelEdit.text.toString())
    }

    companion object {
        const val TAG = "HyperFragment"

        @JvmStatic
        fun newInstance() = HyperFragment()
    }
}