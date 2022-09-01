package com.example.maplecal.presentation.park

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maplecal.R
import com.example.maplecal.domain.model.Park
import com.example.maplecal.databinding.FragmentParkBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ParkFragment : Fragment(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: FragmentParkBinding
    private lateinit var adapter: ParkRecyclerViewAdapter
    @Inject lateinit var parkViewModel: ParkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentParkBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
        parkViewModel.parkLiveData.observe(viewLifecycleOwner) {
            (binding.recyclerView.adapter as ParkRecyclerViewAdapter).setData(it)
        }
    }

    private fun initView(savedInstanceState: Bundle?) {
        initParkRecyclerView(savedInstanceState)
        initParkCheckBox()
        initButton()
    }

    private fun initParkRecyclerView(savedInstanceState: Bundle?) {
        adapter = ParkRecyclerViewAdapter(
            emptyList(),
            parkCountChangeListener = { index, parkCount ->
                parkViewModel.setParkCount(index, parkCount)
            },
            parkPointChangeListener = { index, parkPoint ->
                parkViewModel.setParkPoint(index, parkPoint)
            }
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun initParkCheckBox() {
        binding.parkSun.setOnCheckedChangeListener(this)
        binding.parkMon.setOnCheckedChangeListener(this)
        binding.parkTue.setOnCheckedChangeListener(this)
        binding.parkWed.setOnCheckedChangeListener(this)
        binding.parkThu.setOnCheckedChangeListener(this)
        binding.parkFri.setOnCheckedChangeListener(this)
        binding.parkSat.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(checkbox: CompoundButton, isChecked: Boolean) {
        val park = when (checkbox.id) {
            R.id.park_sun -> 0
            R.id.park_mon -> 1
            R.id.park_tue -> 2
            R.id.park_wed -> 3
            R.id.park_thu -> 4
            R.id.park_fri -> 5
            R.id.park_sat -> 6
            else -> return
        }

        when (isChecked) {
            true -> parkViewModel.setParkChecked(park, true)
            false -> parkViewModel.setParkChecked(park, false)
        }
    }

    fun initButton() {
        binding.calButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelableArrayList("park", ArrayList(parkViewModel.getParkResult()))
            val dialog = ParkDialog()
            dialog.isCancelable = false
            dialog.arguments = bundle
            dialog.show(childFragmentManager, "Park Dialog")
        }
    }

    companion object {
        const val TAG = "ParkFragment"

        @JvmStatic
        fun newInstance() = ParkFragment()
    }
}