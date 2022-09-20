package com.example.maplecal.presentation.hyper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maplecal.domain.GetHyperUseCase
import com.example.maplecal.domain.SetHyperUseCase
import com.example.maplecal.domain.model.Hyper
import com.example.maplecal.util.getGainPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HyperViewModel @Inject constructor(
    private val getHyperUseCase: GetHyperUseCase,
    private val setHyperUseCase: SetHyperUseCase
) : ViewModel() {

    var _hyperLiveData = MutableLiveData<List<Hyper>>()
    val hyperLiveData: LiveData<List<Hyper>>
        get() = _hyperLiveData

    var levelLiveData = MutableLiveData<String>()

    var _remainPointLiveData = MutableLiveData<String>()
    val remainPointLiveData: LiveData<String>
        get() = _remainPointLiveData

    var _resultTextLiveData = MutableLiveData<String>()
    val resultTextLiveData: LiveData<String>
        get() = _resultTextLiveData

    init {
        levelLiveData.value = "0"
        _remainPointLiveData.value = "0"
        _resultTextLiveData.value = ""
    }

    fun updateHypers() {
        _hyperLiveData.value = getHypers()
    }

    fun getHypers(): List<Hyper> {
        return getHyperUseCase.getHypers()
    }

    fun setHyperCount(index: Int, count: String) {
        setHyperUseCase.setHypersCount(index, count)
        setResultText()
    }

    fun setInit() {
        setHyperUseCase.setInit()
        updateHypers()
    }

    fun getRemainPoint(level: String) {
        if (level != "") {
            val levelInt = level.toInt()
            if (levelInt < 140) _remainPointLiveData.value = "0"
            else {
                var usePoint = 0
                for (i in 0 until getHyperUseCase.getHypersSize()) {
                    usePoint += getHyperUseCase.getHyperPoint(i)
                }
                _remainPointLiveData.value = (getGainPoint(levelInt) - usePoint).toString()
            }
        }
    }

    private fun setResultText() {
        val hyperText = StringBuilder()
        for (i in 0 until getHyperUseCase.getHypersSize()) {
            if (getHyperUseCase.getHyperCount(i) > 0) {
                hyperText.append(
                    "${getHyperUseCase.getHyperText(i)}\n"
                )
            }
        }
        _resultTextLiveData.value = hyperText.toString()
        levelLiveData.value?.let { getRemainPoint(it) }
    }
}