package com.example.maplecal.fragment

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maplecal.R
import com.example.maplecal.SymbolData
import com.example.maplecal.SymbolDialog
import com.example.maplecal.SymbolRecyclerViewAdapter
import com.example.maplecal.databinding.FragmentSymbolBinding
import com.example.maplecal.model.symbols
import com.google.android.material.internal.ParcelableSparseArray

class SymbolFragment : Fragment(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding : FragmentSymbolBinding
    private lateinit var adapter : SymbolRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSymbolBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        initSymbolRecyclerView()
        initSymbolCheckBox()
        initButton()
    }

    private fun initSymbolRecyclerView(){
        adapter = SymbolRecyclerViewAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun initSymbolCheckBox(){
        binding.symbolLongways.setOnCheckedChangeListener(this)
        binding.symbolChuchu.setOnCheckedChangeListener(this)
        binding.symbolLehlne.setOnCheckedChangeListener(this)
        binding.symbolArcana.setOnCheckedChangeListener(this)
        binding.symbolMoras.setOnCheckedChangeListener(this)
        binding.symbolEspa.setOnCheckedChangeListener(this)
        binding.symbolCernium.setOnCheckedChangeListener(this)
        binding.symbolArx.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(checkBox: CompoundButton, isChecked: Boolean) {
        val symbol = when(checkBox.id){
            R.id.symbol_longways -> 0
            R.id.symbol_chuchu -> 1
            R.id.symbol_lehlne -> 2
            R.id.symbol_arcana -> 3
            R.id.symbol_moras -> 4
            R.id.symbol_espa -> 5
            R.id.symbol_cernium -> 6
            R.id.symbol_arx -> 7
            else -> return
        }

        when(isChecked) {
            true -> adapter.addItem(symbol)
            false -> adapter.removeItem(symbol)
        }
    }

    fun initButton() {
        binding.calButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelableArrayList("symbol", ArrayList(adapter.datalist))
            val dialog = SymbolDialog()
            activity?.supportFragmentManager?.let { fragmentManager ->
                dialog.show(fragmentManager, "Symbol Dialog")
            }
        }
    }

    companion object {
        const val TAG = "SymbolFragment"

        @JvmStatic
        fun newInstance() = SymbolFragment()
    }
}