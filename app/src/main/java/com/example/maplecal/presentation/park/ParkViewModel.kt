package com.example.maplecal.presentation.park

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maplecal.domain.GetParkUseCase
import com.example.maplecal.domain.SetParkUseCase
import com.example.maplecal.domain.model.Park
import com.example.maplecal.util.getPoint
import com.example.maplecal.util.getTime
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ParkViewModel @Inject constructor(
    private val getParkUseCase: GetParkUseCase,
    private val setParkUseCase: SetParkUseCase
) : ViewModel() {

    var _parkLiveData = MutableLiveData<List<Park>>()
    val parkLiveData: LiveData<List<Park>>
        get() = _parkLiveData

    fun updateParks() {
        _parkLiveData.value = getParkUseCase.getParks()
    }

    fun setParkCount(index: Int, count: String) {
        setParkUseCase.setParkCount(index, count)
    }

    fun setParkPoint(index: Int, point: String) {
        setParkUseCase.setParkPoint(index, point)
    }

    fun setParkChecked(index: Int, boolean: Boolean) {
        setParkUseCase.setParkChecked(index, boolean)
        updateParks()
    }

    fun getParkResult(): MutableList<ParkResult> {
        val parkLists = getParkUseCase.getParks()
        val parkResultList = mutableListOf<ParkResult>()

        for (parkList in parkLists) {
            val index = parkList.parkIndex
            val name = parkList.parkName
            val count = parkList.parkCount
            val point = parkList.parkPoint
            parkResultList.add(
                ParkResult(
                    index, name, getPoint(count.toInt(), point.toInt()),
                    getTime(index, count.toInt(), point.toInt())
                )
            )
        }

        return parkResultList
    }
}