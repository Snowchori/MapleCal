package com.chori.maplecal.presentation.hyper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.chori.maplecal.R
import com.chori.maplecal.databinding.FragmentHyperBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HyperFragment : Fragment() {
    private lateinit var binding: FragmentHyperBinding
    private lateinit var adapter: HyperRecyclerViewAdapter
    private val hyperViewModel: HyperViewModel by activityViewModels()

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
        binding.lifecycleOwner = this
        binding.viewModel = hyperViewModel
        hyperViewModel.hyperLiveData.observe(viewLifecycleOwner) {
            (binding.recyclerView.adapter as HyperRecyclerViewAdapter).setData(it)
        }
        hyperViewModel.levelLiveData.observe(viewLifecycleOwner) {
            hyperViewModel.getRemainPoint(it)
        }
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
            requireContext()
        )
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