package com.example.maplecal.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.maplecal.databinding.FragmentGrowthBinding
import com.example.maplecal.model.getExpResult
import kotlinx.coroutines.*
import java.lang.NumberFormatException

class GrowthFragment : Fragment() {
    private lateinit var binding: FragmentGrowthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGrowthBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {
        initButton()
        if (savedInstanceState != null) {
            val nickname = savedInstanceState.getString("nickname")
            if (nickname != null) binding.nickname.setText(nickname)
            val levelEdit = savedInstanceState.getString("levelEdit")
            if (levelEdit != null) binding.levelEdit.setText(levelEdit)
            val expEdit = savedInstanceState.getString("expEdit")
            if (expEdit != null) binding.expEdit.setText(expEdit)
            val extremeEdit = savedInstanceState.getString("extremeEdit")
            if (extremeEdit != null) binding.extremeEdit.setText(extremeEdit)
            val growth1Edit = savedInstanceState.getString("growth1Edit")
            if (growth1Edit != null) binding.growth1Edit.setText(growth1Edit)
            val growth2Edit = savedInstanceState.getString("growth2Edit")
            if (growth2Edit != null) binding.growth2Edit.setText(growth2Edit)
            val growth3Edit = savedInstanceState.getString("growth3Edit")
            if (growth3Edit != null) binding.growth3Edit.setText(growth3Edit)
            val typhoonEdit = savedInstanceState.getString("typhoonEdit")
            if (typhoonEdit != null) binding.typhoonEdit.setText(typhoonEdit)
            val limitEdit = savedInstanceState.getString("limitEdit")
            if (limitEdit != null) binding.limitEdit.setText(limitEdit)
        }
    }

    private fun initButton() {
        binding.calButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).async {
                try {
                    val data = mutableListOf<Int>()
                    data.add(binding.extremeEdit.text.toString().toInt())
                    data.add(binding.growth1Edit.text.toString().toInt())
                    data.add(binding.growth2Edit.text.toString().toInt())
                    data.add(binding.growth3Edit.text.toString().toInt())
                    data.add(binding.typhoonEdit.text.toString().toInt())
                    data.add(binding.limitEdit.text.toString().toInt())
                    val level = binding.levelEdit.text.toString().toInt()
                    val percent = binding.expEdit.text.toString().toDouble()
                    val result = async {
                        getExpResult(level, percent, data)
                    }
                    withContext(Dispatchers.Main) {
                        binding.resultEdit.setText(result.await())
                    }
                } catch (e: NumberFormatException) {
                    withContext(Dispatchers.Main) {
                        binding.resultEdit.setText("입력값 오류")
                    }
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nickname", binding.nickname.text.toString())
        outState.putString("levelEdit", binding.levelEdit.text.toString())
        outState.putString("expEdit", binding.expEdit.text.toString())
        outState.putString("extremeEdit", binding.extremeEdit.text.toString())
        outState.putString("growth1Edit", binding.growth1Edit.text.toString())
        outState.putString("growth2Edit", binding.growth2Edit.text.toString())
        outState.putString("growth3Edit", binding.growth3Edit.text.toString())
        outState.putString("typhoonEdit", binding.typhoonEdit.text.toString())
        outState.putString("limitEdit", binding.limitEdit.text.toString())
    }

    companion object {
        const val TAG = "GrowthFragment"

        @JvmStatic
        fun newInstance() = GrowthFragment()
    }
}