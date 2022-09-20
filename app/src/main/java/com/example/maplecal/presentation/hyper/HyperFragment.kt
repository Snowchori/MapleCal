package com.example.maplecal.presentation.hyper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maplecal.ItemSelectedListener
import com.example.maplecal.R
import com.example.maplecal.domain.model.Hyper
import com.example.maplecal.databinding.FragmentHyperBinding
import com.example.maplecal.databinding.FragmentParkBinding
import com.example.maplecal.util.getHyperState
import dagger.hilt.android.AndroidEntryPoint
import java.lang.NumberFormatException
import java.lang.StringBuilder
import javax.inject.Inject

@AndroidEntryPoint
class HyperFragment : Fragment() {
    private lateinit var binding: FragmentHyperBinding
    private lateinit var adapter: HyperRecyclerViewAdapter
    private val hyperViewModel: HyperViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hyper, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        hyperViewModel.hyperLiveData.observe(viewLifecycleOwner) {
            (binding.recyclerView.adapter as HyperRecyclerViewAdapter).setData(it)
        }
        hyperViewModel.levelLiveData.observe(viewLifecycleOwner) {
            hyperViewModel.getRemainPoint(it)
        }
        binding.lifecycleOwner = this
        binding.viewModel = hyperViewModel
    }

    private fun initView() {
        initHyperRecyclerView()
        initButton()
    }

    private fun initHyperRecyclerView() {
        adapter = HyperRecyclerViewAdapter(
            hyperViewModel.getHypers(),
            hyperCountChangeListener = { index, hyperCount ->
                hyperViewModel.setHyperCount(index, hyperCount)
            },
            requireContext())
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun initButton() {
        binding.initButton.setOnClickListener {
            hyperViewModel.setInit()
        }
    }

    companion object {
        const val TAG = "HyperFragment"

        @JvmStatic
        fun newInstance() = HyperFragment()
    }
}