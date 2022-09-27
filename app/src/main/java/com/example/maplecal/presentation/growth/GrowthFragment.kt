package com.example.maplecal.presentation.growth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.maplecal.R
import com.example.maplecal.databinding.FragmentGrowthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GrowthFragment : Fragment() {
    private lateinit var binding: FragmentGrowthBinding
    private val growthViewModel: GrowthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_growth, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.lifecycleOwner = this
        binding.viewModel = growthViewModel
    }

    private fun initView() {
        initButton()
    }

    private fun initButton() {
        binding.calButton.setOnClickListener {
            growthViewModel.calculateExp()
        }

        binding.searchButton.setOnClickListener {
            growthViewModel.searchExpLevel()
        }
    }

    companion object {
        const val TAG = "GrowthFragment"

        @JvmStatic
        fun newInstance() = GrowthFragment()
    }
}