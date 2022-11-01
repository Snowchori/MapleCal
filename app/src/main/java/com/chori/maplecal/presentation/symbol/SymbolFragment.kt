package com.chori.maplecal.presentation.symbol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.chori.maplecal.R
import com.chori.maplecal.databinding.FragmentSymbolBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SymbolFragment : Fragment(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: FragmentSymbolBinding
    private lateinit var adapter: SymbolRecyclerViewAdapter
    private val symbolViewModel: SymbolViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_symbol, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.lifecycleOwner = this
        symbolViewModel.symbolLiveData.observe(viewLifecycleOwner) {
            (binding.recyclerView.adapter as SymbolRecyclerViewAdapter).setData(it)
        }
    }

    private fun initView() {
        initSymbolRecyclerView()
        initSymbolCheckBox()
        initButton()
    }

    private fun initSymbolRecyclerView() {
        adapter = SymbolRecyclerViewAdapter(
            symbolLevelChangeListener = { index, symbolLevel ->
                symbolViewModel.setSymbolLevel(index, symbolLevel)
            }, symbolCountChangeListener = { index, symbolCount ->
                symbolViewModel.setSymbolCount(index, symbolCount)
            }, symbolMiniChangeListener = { index, symbolMini ->
                symbolViewModel.setSymbolExtra(index, symbolMini)
            })
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun initSymbolCheckBox() {
        binding.symbolLongways.setOnCheckedChangeListener(this)
        binding.symbolLongways.isChecked = symbolViewModel.getSymbolCheked("longways")
        binding.symbolChuchu.setOnCheckedChangeListener(this)
        binding.symbolChuchu.isChecked = symbolViewModel.getSymbolCheked("chuchu")
        binding.symbolLehlne.setOnCheckedChangeListener(this)
        binding.symbolLehlne.isChecked = symbolViewModel.getSymbolCheked("lehlne")
        binding.symbolArcana.setOnCheckedChangeListener(this)
        binding.symbolArcana.isChecked = symbolViewModel.getSymbolCheked("arcana")
        binding.symbolMoras.setOnCheckedChangeListener(this)
        binding.symbolMoras.isChecked = symbolViewModel.getSymbolCheked("moras")
        binding.symbolEspa.setOnCheckedChangeListener(this)
        binding.symbolEspa.isChecked = symbolViewModel.getSymbolCheked("espa")
        binding.symbolCernium.setOnCheckedChangeListener(this)
        binding.symbolCernium.isChecked = symbolViewModel.getSymbolCheked("cernium")
        binding.symbolArx.setOnCheckedChangeListener(this)
        binding.symbolArx.isChecked = symbolViewModel.getSymbolCheked("arx")
    }

    override fun onCheckedChanged(checkBox: CompoundButton, isChecked: Boolean) {
        val symbol = when (checkBox.id) {
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

        when (isChecked) {
            true -> symbolViewModel.setSymbolCheked(symbol, true)
            false -> symbolViewModel.setSymbolCheked(symbol, false)
        }
    }

    fun initButton() {
        binding.calButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelableArrayList("symbol", ArrayList(symbolViewModel.getSymbolResult()))
            val dialog = SymbolDialog()
            dialog.isCancelable = false
            dialog.arguments = bundle
            dialog.show(childFragmentManager, "Symbol Dialog")
        }
    }

    companion object {
        const val TAG = "SymbolFragment"

        @JvmStatic
        fun newInstance() = SymbolFragment()
    }
}