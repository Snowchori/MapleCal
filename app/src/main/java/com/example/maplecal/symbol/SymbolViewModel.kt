package com.example.maplecal.symbol

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.example.maplecal.R
import com.example.maplecal.domain.model.Symbol
import com.example.maplecal.domain.GetSymbolUsecase
import com.example.maplecal.domain.SetSymbolUsecase
import java.security.PrivateKey
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class SymbolViewModel(
    private val getSymbolUsecase: GetSymbolUsecase,
    private val setSymbolUsecase: SetSymbolUsecase
) : ViewModel() {
    // datasource 합치고 거기에 넣기 drawable은 enum으로 빼서 관리

    // 뷰모델에서 계산을한 결과를 보내주기만해서 받고 띄우기만
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

