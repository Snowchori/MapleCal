package com.example.maplecal.presentation.symbol

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maplecal.domain.GetSymbolUseCase
import com.example.maplecal.domain.SetSymbolUseCase
import com.example.maplecal.domain.model.Symbol
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SymbolViewModel @Inject constructor(
    private val getSymbolUseCase: GetSymbolUseCase,
    private val setSymbolUseCase: SetSymbolUseCase
) : ViewModel() {

    var _symbolLiveData = MutableLiveData<List<Symbol>>()
    val symbolLiveData: LiveData<List<Symbol>>
        get() = _symbolLiveData

    fun updateSymbols() {
        _symbolLiveData.value = getSymbolUseCase.getSymbols()
    }

    fun setSymbolLevel(index: Int, level: String) {
        setSymbolUseCase.setSymbolLevel(index, level)
    }

    fun setSymbolCount(index: Int, count: String) {
        setSymbolUseCase.setSymbolCount(index, count)
    }

    fun setSymbolExtra(index: Int, mini: String) {
        setSymbolUseCase.setSymbolExtra(index, mini)
    }

    fun setSymbolCheked(index: Int, boolean: Boolean) {
        setSymbolUseCase.setSymbolCheked(index, boolean)
        updateSymbols()
    }

    fun getSymbolResult(): MutableList<SymbolResult> {
        val symbolLists = getSymbolUseCase.getSymbols()
        val symbolResultList = mutableListOf<SymbolResult>()
        for (symbolList in symbolLists) {
            val index = symbolList.symbolIndex
            val name = symbolList.symbolName
            val level = symbolList.symbolLevel
            val count = symbolList.symbolCount
            val mini = symbolList.symbolMini
            symbolResultList.add(
                SymbolResult(
                    index, name, getMeso(index, level.toInt()), getTime(
                        index, level.toInt(),
                        count.toInt(), mini.toInt()
                    )
                )
            )
        }

        return symbolResultList
    }

    private fun getMeso(ind: Int, level: Int): String {
        val dec = DecimalFormat("#,###")
        val meso = when (ind) {
            0 -> getSymbolUseCase.getArcaneMesoLongway(level, 20)
            1 -> getSymbolUseCase.getArcaneMesoChuchu(level, 20)
            2 -> getSymbolUseCase.getArcaneMesoLehlne(level, 20)
            3 -> getSymbolUseCase.getArcaneMesoArcana(level, 20)
            4 -> getSymbolUseCase.getArcaneMesoMoras(level, 20)
            5 -> getSymbolUseCase.getArcaneMesoEspa(level, 20)
            6 -> getSymbolUseCase.getAuthenticMesoCernium(level, 11)
            7 -> getSymbolUseCase.getAuthenticMesoArx(level, 11)
            else -> -1
        }

        return dec.format(meso)
    }

    @SuppressLint("SimpleDateFormat")
    private fun getTime(ind: Int, level: Int, count: Int, mini: Int): String {
        var remain: Int = when (ind) {
            0, 1, 2, 3, 4, 5 -> getSymbolUseCase.getArcaneGrowth(level - 1, 19)
            6, 7 -> getSymbolUseCase.getAuthenticGrowth(level - 1, 10)
            else -> 0
        }

        remain -= count

        val day: Int = when (ind) {
            0 -> 16 + 6 * mini
            1 -> 8 + 15 * mini
            2 -> 9 + mini / 10
            3 -> 8 + mini / 3000
            4, 5 -> 8 + 6 * mini
            6 -> 5 + 5 * mini
            7 -> 5
            else -> -1
        }

        val t: Int = (remain + 1) / day

        val cal = Calendar.getInstance()
        cal.time = Date()
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")

        cal.add(Calendar.DATE, t)

        return df.format(cal.time)
    }
}

