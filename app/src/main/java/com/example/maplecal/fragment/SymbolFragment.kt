package com.example.maplecal.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maplecal.R
import com.example.maplecal.SymbolData
import com.example.maplecal.SymbolDialog
import com.example.maplecal.SymbolRecyclerViewAdapter
import com.example.maplecal.databinding.FragmentSymbolBinding
import com.example.maplecal.model.getSymbol

class SymbolFragment : Fragment(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding : FragmentSymbolBinding
    private lateinit var adapter : SymbolRecyclerViewAdapter
    private lateinit var symbols : Array<SymbolData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSymbolBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?){
        symbols = getSymbol()
        initSymbolRecyclerView(savedInstanceState)
        initSymbolCheckBox()
        initButton()
    }

    private fun initSymbolRecyclerView(savedInstanceState: Bundle?){
        adapter = SymbolRecyclerViewAdapter()
        if (savedInstanceState != null) {
            val data = mutableListOf<SymbolData>()
            val saveData = savedInstanceState.getParcelableArrayList<SymbolData>("symbolData")
            if (saveData != null) {
                for (i in 0 until saveData.size){
                    data.add(saveData[i])
                }
            }
            adapter.datalist = data
        }
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
            true -> adapter.addItem(symbols[symbol], symbol)
            false -> adapter.removeItem(symbol)
        }
    }

    fun initButton() {
        binding.calButton.setOnClickListener {
            Log.e("eee", ArrayList(adapter.datalist).toString())
            val bundle = Bundle()
            bundle.putParcelableArrayList("symbol", ArrayList(adapter.datalist))
            val dialog = SymbolDialog()
            dialog.arguments = bundle
            childFragmentManager.let { fragmentManager ->
                dialog.show(fragmentManager, "Symbol Dialog")
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("symbolData", ArrayList(adapter.datalist))
    }

    companion object {
        const val TAG = "SymbolFragment"

        @JvmStatic
        fun newInstance() = SymbolFragment()
    }
}