package com.example.maplecal.presentation.hyper

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maplecal.domain.GetHyperUsecase
import com.example.maplecal.domain.SetHyperUsecase
import com.example.maplecal.domain.model.Hyper
import com.example.maplecal.util.getGainPoint
import com.example.maplecal.util.getHyperState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.StringBuilder
import javax.inject.Inject

@HiltViewModel
class HyperViewModel @Inject constructor(
    private val getHyperUsecase: GetHyperUsecase,
    private val setHyperUsecase: SetHyperUsecase
) : ViewModel() {

    var _hyperLiveData = MutableLiveData<List<Hyper>>()
    val hyperLiveData : LiveData<List<Hyper>>
    get() = _hyperLiveData

    var levelLiveData = MutableLiveData<String>()

    var _remainPointLiveData = MutableLiveData<String>()
    val remainPointLiveData : LiveData<String>
    get() = _remainPointLiveData

    var _resultTextLiveData = MutableLiveData<String>()
    val resultTextLiveData : LiveData<String>
    get() = _resultTextLiveData

    init {
        levelLiveData.value = "0"
        _remainPointLiveData.value = "0"
        _resultTextLiveData.value = ""
    }

    fun updateHypers() {
        _hyperLiveData.value = getHypers()
    }

    fun getHypers() : List<Hyper> {
        return getHyperUsecase.getHypers()
    }

    fun setHyperCount(index : Int, count : String) {
        setHyperUsecase.setHypersCount(index, count)
        setResultText()
    }

    fun setInit() {
        setHyperUsecase.setInit()
        updateHypers()
    }

    fun getRemainPoint(level: String){
        if (level != "") {
            val levelInt = level.toInt()
            if (levelInt < 140) _remainPointLiveData.value = "0"
            else {
                var usePoint = 0
                for (i in 0 until getHyperUsecase.getHypersSize()){
                    usePoint += getHyperUsecase.getHyperPoint(i)
                }
                _remainPointLiveData.value = (getGainPoint(levelInt) - usePoint).toString()
            }
        }
    }

    private fun setResultText(){
        val hyperText = StringBuilder()
        for (i in 0 until getHyperUsecase.getHypersSize()) {
            if (getHyperUsecase.getHyperCount(i) > 0) {
                hyperText.append(
                    "${getHyperUsecase.getHyperText(i)}\n"
                )
            }
        }
        _resultTextLiveData.value = hyperText.toString()
        levelLiveData.value?.let { getRemainPoint(it) }
    }
}