package com.example.maplecal.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.maplecal.R
import com.example.maplecal.databinding.DialogLoadingBinding

class LoadingDialog : DialogFragment() {

    private lateinit var binding : DialogLoadingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogLoadingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    fun initView() {
        context?.let { Glide.with(it).load(R.raw.circlesmenu).into(binding.loadingImage) }
    }
}