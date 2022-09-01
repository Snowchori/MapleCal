package com.example.maplecal.presentation.symbol

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maplecal.domain.GetSymbolUsecase
import com.example.maplecal.domain.SetSymbolUsecase
import com.example.maplecal.domain.model.Symbol
import dagger.hilt.android.scopes.ViewModelScoped
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class SymbolViewModel @Inject constructor(
    private val getSymbolUsecase: GetSymbolUsecase,
    private val setSymbolUsecase: SetSymbolUsecase
) : ViewModel() {

    val symbolLiveData = MutableLiveData<List<Symbol>>()

    fun updateSymbols() {
        symbolLiveData.value = getSymbolUsecase.getSymbols()
    }

    fun setSymbolLevel(index: Int, level: String) {
        setSymbolUsecase.setSymbolLevel(index, level)
    }

    fun setSymbolCount(index: Int, count: String) {
        setSymbolUsecase.setSymbolCount(index, count)
    }

    fun setSymbolExtra(index: Int, mini: String) {
        setSymbolUsecase.setSymbolExtra(index, mini)
    }

    fun setSymbolCheked(index: Int, boolean: Boolean) {
        setSymbolUsecase.setSymbolCheked(index, boolean)
        updateSymbols()
    }

    fun getSymbolResult() : MutableList<SymbolResult> {
        val symbolLists = getSymbolUsecase.getSymbols()
        val symbolResultList = mutableListOf<SymbolResult>()
        for (symbolList in symbolLists) {
            val index = symbolList.symbolIndex
            val name = symbolList.symbolName
            val level = symbolList.symbolLevel
            val count = symbolList.symbolCount
            val mini = symbolList.symbolMini
            symbolResultList.add(
                SymbolResult(index, name, getMeso(index, level.toInt()), getTime(index, level.toInt(),
                count.toInt(), mini.toInt()))
            )
        }

        return symbolResultList
    }

    private fun getMeso(ind: Int, level: Int): String {
        val dec = DecimalFormat("#,###")
        val meso = when (ind) {
            0 -> getSymbolUsecase.getArcaneMesoLongway(level, 20)
            1 -> getSymbolUsecase.getArcaneMesoChuchu(level, 20)
            2 -> getSymbolUsecase.getArcaneMesoLehlne(level, 20)
            3 -> getSymbolUsecase.getArcaneMesoArcana(level, 20)
            4 -> getSymbolUsecase.getArcaneMesoMoras(level, 20)
            5 -> getSymbolUsecase.getArcaneMesoEspa(level, 20)
            6 -> getSymbolUsecase.getAuthenticMesoCernium(level, 11)
            7 -> getSymbolUsecase.getAuthenticMesoArx(level, 11)
            else -> -1
        }

        return dec.format(meso)
    }

    @SuppressLint("SimpleDateFormat")
    private fun getTime(ind: Int, level: Int, count: Int, mini: Int): String {
        var remain: Int = when (ind) {
            0, 1, 2, 3, 4, 5 -> getSymbolUsecase.getArcaneGrowth(level - 1, 19)
            6, 7 -> getSymbolUsecase.getAuthenticGrowth(level - 1, 10)
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

