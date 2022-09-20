package com.example.maplecal.presentation.park

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maplecal.domain.GetParkUsecase
import com.example.maplecal.domain.SetParkUsecase
import com.example.maplecal.domain.model.Park
import com.example.maplecal.util.getPoint
import com.example.maplecal.util.getTime
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class ParkViewModel @Inject constructor(
    private val getParkUsecase: GetParkUsecase,
    private val setParkUsecase: SetParkUsecase
) : ViewModel() {

    var _parkLiveData = MutableLiveData<List<Park>>()
    val parkLiveData : LiveData<List<Park>>
    get() = _parkLiveData

    fun updateParks() {
        _parkLiveData.value = getParkUsecase.getParks()
    }

    fun setParkCount(index: Int, count: String) {
        setParkUsecase.setParkCount(index, count)
    }

    fun setParkPoint(index: Int, point: String) {
        setParkUsecase.setParkPoint(index, point)
    }

    fun setParkChecked(index:Int, boolean: Boolean) {
        setParkUsecase.setParkChecked(index, boolean)
        updateParks()
    }

    fun getParkResult() : MutableList<ParkResult> {
        val parkLists = getParkUsecase.getParks()
        val parkResultList = mutableListOf<ParkResult>()

        for (parkList in parkLists) {
            val index = parkList.parkIndex
            val name = parkList.parkName
            val count = parkList.parkCount
            val point = parkList.parkPoint
            parkResultList.add(
                ParkResult(index, name, getPoint(count.toInt(), point.toInt()),
                    getTime(index, count.toInt(), point.toInt()))
            )
        }

        return parkResultList
    }
}