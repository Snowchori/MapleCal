package com.example.maplecal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.maplecal.databinding.SymbolDialogBinding

class SymbolDialog : DialogFragment() {
    private lateinit var binding : SymbolDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SymbolDialogBinding.inflate(layoutInflater)
        val bundle = arguments
        val notice = bundle?.getParcelableArray("symbol")
        binding.symbolText.text = notice.toString()
        return binding.root
    }
}