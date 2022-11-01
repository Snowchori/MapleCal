package com.chori.maplecal.presentation.growth

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chori.maplecal.LoadingDialog
import com.chori.maplecal.domain.GetGrowthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GrowthViewModel @Inject constructor(
    private val getGrowthUseCase: GetGrowthUseCase
) : ViewModel() {
    var nicknameLiveData = MutableLiveData<String>()
    var levelLiveData = MutableLiveData<String>()
    var expLiveData = MutableLiveData<String>()
    var extremeLiveData = MutableLiveData<String>()
    var growth1LiveData = MutableLiveData<String>()
    var growth2LiveData = MutableLiveData<String>()
    var growth3LiveData = MutableLiveData<String>()
    var typhoonLiveData = MutableLiveData<String>()
    var limitLiveData = MutableLiveData<String>()
    var resultLiveData = MutableLiveData<String>()

    init {
        nicknameLiveData.value = ""
        levelLiveData.value = "200"
        expLiveData.value = "0.0"
        extremeLiveData.value = "0"
        growth1LiveData.value = "0"
        growth2LiveData.value = "0"
        growth3LiveData.value = "0"
        typhoonLiveData.value = "0"
        limitLiveData.value = "0"
        resultLiveData.value = "0"
    }

    fun calculateExp(fragmentManager: FragmentManager) {
        viewModelScope.launch {
            val dialog = LoadingDialog()
            dialog.show(fragmentManager, "LoadingDialog")
            try {
                val data = mutableListOf<Int>()
                extremeLiveData.value?.let { data.add(it.toInt()) }
                growth1LiveData.value?.let { data.add(it.toInt()) }
                growth2LiveData.value?.let { data.add(it.toInt()) }
                growth3LiveData.value?.let { data.add(it.toInt()) }
                typhoonLiveData.value?.let { data.add(it.toInt()) }
                limitLiveData.value?.let { data.add(it.toInt()) }
                resultLiveData.value = levelLiveData.value?.let {
                    expLiveData.value?.let { it1 ->
                        getGrowthUseCase.getExpResult(
                            it.toInt(),
                            it1.toDouble(), data
                        )
                    }
                }
            } catch (e: NumberFormatException) {
                resultLiveData.value = "입력값 오류"
            }
            dialog.dismiss()
        }
    }

    fun searchExpLevel(fragmentManager: FragmentManager) {
        viewModelScope.launch {
            val dialog = LoadingDialog()
            dialog.show(fragmentManager, "LoadingDialog")
            val expLevel = nicknameLiveData.value?.let { getGrowthUseCase.getExpLevel(it) }
            if (expLevel != null) {
                levelLiveData.value = expLevel.first!!
                expLiveData.value = String.format("%.3f", expLevel.second)
            }
            dialog.dismiss()
        }
    }
}