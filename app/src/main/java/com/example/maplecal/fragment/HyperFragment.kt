package com.example.maplecal.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maplecal.ItemSelectedListener
import com.example.maplecal.adapter.HyperRecyclerViewAdapter
import com.example.maplecal.data.HyperData
import com.example.maplecal.databinding.FragmentHyperBinding
import com.example.maplecal.model.getGainPoint
import com.example.maplecal.model.getHyper
import com.example.maplecal.model.getHyperState
import com.example.maplecal.model.hyperPoint
import java.lang.NumberFormatException
import java.lang.StringBuilder

class HyperFragment : Fragment(), ItemSelectedListener {
    private lateinit var binding: FragmentHyperBinding
    private lateinit var adapter: HyperRecyclerViewAdapter
    private lateinit var hypers: Array<HyperData>
    private var characterLevel: Int = 0

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
                characterLevel = Integer.parseInt(it.toString())
                binding.pointText.setText(getRemainPoint(characterLevel))
            } catch (e: NumberFormatException) {
            }
        }
        if (savedInstanceState != null) {
            val level = savedInstanceState.getString("level")
            if (level != null) binding.levelEdit.setText(level)
        }
    }

    private fun initHyperRecyclerView(savedInstanceState: Bundle?) {
        adapter = HyperRecyclerViewAdapter(this, requireContext())
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
            hypers = getHyper()
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

    override fun onHyperSelected(data: MutableList<HyperData>) {
        binding.pointText.setText(getRemainPoint(characterLevel))
        var hyperText = StringBuilder()
        for (i in 0 until adapter.datalist.size) {
            if (adapter.datalist[i].hyperCount > 0) {
                hyperText.append(
                    "${adapter.datalist[i].hyperName} ${
                        getHyperState(
                            adapter.datalist[i].hyperIndex,
                            adapter.datalist[i].hyperCount
                        )
                    }\n"
                )
            }
        }
        binding.hyperResult.setText(hyperText.toString())
    }

    private fun getRemainPoint(level: Int): String {
        return if (level < 140) "0"
        else {
            var usePoint = 0
            for (i in 0 until adapter.datalist.size) usePoint += hyperPoint[adapter.datalist[i].hyperCount]

            (getGainPoint(level) - usePoint).toString()
        }
    }

    companion object {
        const val TAG = "HyperFragment"

        @JvmStatic
        fun newInstance() = HyperFragment()
    }
}